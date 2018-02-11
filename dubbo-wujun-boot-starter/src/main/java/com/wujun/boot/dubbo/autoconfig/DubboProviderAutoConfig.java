package com.wujun.boot.dubbo.autoconfig;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.MonitorConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.ServiceBean;
import com.wujun.boot.dubbo.prop.DubboProviderProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author wujun
 * @description dubbo服务提供者自动配置
 * @date 18/2/11.
 */
@Configuration
@AutoConfigureAfter(value = DubboAutoConfig.class)
@EnableConfigurationProperties(value = DubboProviderProperties.class)
@ConditionalOnProperty(prefix = "wujun.dubbo.provider",value = "enable",havingValue = "true")
public class DubboProviderAutoConfig {
    private static Logger logger = LoggerFactory.getLogger(DubboProviderAutoConfig.class);

    private final ApplicationContext applicationContext;

    private final DubboProviderProperties dubboProviderProperties;

    private final ApplicationConfig applicationConfig;

    private final ProtocolConfig protocolConfig;

    private final RegistryConfig registryConfig;

    private final MonitorConfig monitorConfig;

    private final ProviderConfig providerConfig;

    public DubboProviderAutoConfig(ApplicationContext applicationContext,
                                   DubboProviderProperties dubboProviderProperties,
                                   ApplicationConfig applicationConfig,
                                   ProtocolConfig protocolConfig,
                                   RegistryConfig registryConfig,
                                   MonitorConfig monitorConfig,
                                   ProviderConfig providerConfig) {
        this.applicationContext = applicationContext;
        this.dubboProviderProperties = dubboProviderProperties;
        this.applicationConfig = applicationConfig;
        this.protocolConfig = protocolConfig;
        this.registryConfig = registryConfig;
        this.monitorConfig = monitorConfig;
        this.providerConfig = providerConfig;
    }

    @PostConstruct
    public void init() {
        logger.info("开始dubbo服务提供者自动配置...");
        dubboProviderProperties.getServices().forEach(this::initProviderBean);
        logger.info("dubbo服务提供者自动配置完成.");
    }

    /**
     * dubbo服务提供者启动
     */
    private void initProviderBean(DubboProviderProperties.Service service) {
        ServiceBean<Object> serviceBean = new ServiceBean<>();
        serviceBean.setInterface(service.getInterfaceClass());
        serviceBean.setRef(applicationContext.getBean(service.getRef()));
        serviceBean.setProvider(providerConfig);
        serviceBean.setApplicationContext(applicationContext);
        serviceBean.setApplication(applicationConfig);
        serviceBean.setProtocol(protocolConfig);
        serviceBean.setRegistry(registryConfig);
        serviceBean.setMonitor(monitorConfig);
        try {
            serviceBean.afterPropertiesSet();
        } catch (Exception e) {
            logger.error("dubbo服务提供者启动失败.interface=>" +
                    service.getInterfaceClass().getName() + ",ref=>" + service.getRef());
            throw new IllegalStateException(e);
        }
        serviceBean.export();
    }


}
