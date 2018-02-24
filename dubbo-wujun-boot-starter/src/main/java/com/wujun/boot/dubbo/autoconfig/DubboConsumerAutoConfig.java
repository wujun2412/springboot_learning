package com.wujun.boot.dubbo.autoconfig;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.MonitorConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.ReferenceBean;
import com.wujun.boot.dubbo.prop.DubboConsumerProperties;
import com.wujun.common.utils.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author wujun
 * @description dubbo消费方自动配置
 * @date 18/2/11.
 */
@Configuration
@AutoConfigureAfter(value = DubboAutoConfig.class)
@EnableConfigurationProperties(value = DubboConsumerProperties.class)
@ConditionalOnProperty(prefix = "wujun.dubbo.consumer",value = "enable",havingValue = "true")
public class DubboConsumerAutoConfig {
    private static Logger logger = LoggerFactory.getLogger(DubboConsumerAutoConfig.class);

    private final ApplicationContext applicationContext;

    private final DubboConsumerProperties dubboConsumerProperties;

    private final ApplicationConfig applicationConfig;

    private final RegistryConfig registryConfig;

    private final MonitorConfig monitorConfig;

    private final ConsumerConfig consumerConfig;

    private ConfigurableListableBeanFactory beanFactory;

    @Autowired(required = false)
    private Map<String, DubboConsumerProperties.Reference> referenceMap;

    private static final AtomicBoolean INITED = new AtomicBoolean(false);

    public DubboConsumerAutoConfig(ApplicationContext applicationContext,
                                   DubboConsumerProperties dubboConsumerProperties,
                                   ApplicationConfig applicationConfig,
                                   RegistryConfig registryConfig,
                                   MonitorConfig monitorConfig,
                                   ConsumerConfig consumerConfig) {
        this.applicationContext = applicationContext;
        this.dubboConsumerProperties = dubboConsumerProperties;
        this.applicationConfig = applicationConfig;
        this.registryConfig = registryConfig;
        this.monitorConfig = monitorConfig;
        this.consumerConfig = consumerConfig;

        if (applicationContext instanceof AbstractApplicationContext) {
            this.beanFactory = ((AbstractApplicationContext) applicationContext).getBeanFactory();
        } else {
            throw new IllegalStateException("dubbo消费者启动失败.请检查配置");
        }
    }

    /**
     * 这里预处理bean中对dubbo服务的引用，因为spring解析bean在@PostConstruct之前
     */
    @Bean
    public BeanPostProcessor beanPostProcessor() {
        return new BeanPostProcessor() {
            @Override
            public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                if (!INITED.get() && INITED.compareAndSet(false, true)) {
                    logger.info("开始初始化dubbo consumer bean...");
                    List<DubboConsumerProperties.Reference> references = new ArrayList<>();
                    List<DubboConsumerProperties.Reference> propertiesReferences = dubboConsumerProperties.getReferences();
                    if (CollectionUtils.isNotEmpty(propertiesReferences)) {
                        references.addAll(propertiesReferences);
                    }
                    // 加入通过注册bean形式的reference
                    if (CollectionUtils.isNotEmpty(referenceMap)) {
                        references.addAll(referenceMap.values());
                    }
                    // 设置dubbo consumer bean
                    for (DubboConsumerProperties.Reference reference : references) {
                        // 如果已经存在，则跳过
                        String beanId = reference.getBeanId();
                        if (isContainInSpring(beanId)) {
                            logger.warn("通过dubbo消费者引用的服务已经在spring容器中注册,beanId=>" + beanId);
                            continue;
                        }
                        // 注册到spring容器
                        registry2Spring(beanId, referenceBean(reference));
                    }
                    logger.info("初始化dubbo consumer bean成功");
                }
                return bean;
            }

            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                return bean;
            }
        };
    }

    /**
     * 指定beanName的bean是否已经注册到spring容器中
     */
    private boolean isContainInSpring(String beanName) {
        return beanFactory.containsBean(beanName);
    }

    /**
     * 注册远程服务到spring容器
     */
    private void registry2Spring(String beanId, Object o) {
        beanFactory.registerSingleton(beanId, o);
    }

    /**
     * 远程调用服务
     */
    private Object referenceBean(DubboConsumerProperties.Reference reference) {
        ReferenceBean<Object> consumerBean = new ReferenceBean<>();
        consumerBean.setInterface(reference.getInterfaceClass());
        consumerBean.setId(reference.getBeanId());
        consumerBean.setConsumer(consumerConfig);
        consumerBean.setApplicationContext(applicationContext);
        consumerBean.setApplication(applicationConfig);
        consumerBean.setRegistry(registryConfig);
        consumerBean.setMonitor(monitorConfig);
        consumerBean.setAsync(reference.getAsync());
        // 设置特殊属性
        String group = reference.getGroup();
        if (StringUtils.isNotBlank(group)) {
            consumerBean.setGroup(group);
        }
        String version = reference.getVersion();
        if (StringUtils.isNotBlank(version)) {
            consumerBean.setVersion(version);
        }

        Object result;
        try {
            consumerBean.afterPropertiesSet();
            result = consumerBean.getObject();
        } catch (Exception e) {
            logger.error("远程引用服务失败.interface=>" +
                    reference.getInterfaceClass().getName() + ",bean Id=>" + reference.getBeanId());
            throw new IllegalStateException(e);
        }
        return result;
    }

}
