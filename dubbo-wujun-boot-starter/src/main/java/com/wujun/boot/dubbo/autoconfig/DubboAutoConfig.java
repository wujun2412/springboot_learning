package com.wujun.boot.dubbo.autoconfig;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.MonitorConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.wujun.boot.dubbo.prop.DubboConsumerProperties;
import com.wujun.boot.dubbo.prop.DubboProperties;
import com.wujun.boot.dubbo.prop.DubboProviderProperties;
import com.wujun.common.utils.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wujun
 * @description dubbo基础配置
 * @date 18/2/11.
 */
@Configuration
@EnableConfigurationProperties(value = DubboProperties.class)
public class DubboAutoConfig {
    private final DubboProperties dubboProperties;

    public DubboAutoConfig(DubboProperties dubboProperties) {
        this.dubboProperties = dubboProperties;
    }

    /**
     * dubbo应用配置
     */
    @Bean
    @ConditionalOnMissingBean
    public ApplicationConfig applicationConfig(){
        DubboProperties.Application application = dubboProperties.getApplication();
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName(application.getName());
        applicationConfig.setOwner(application.getOwner());
        applicationConfig.setLogger("slf4j");
        String directory = application.getDumpDirectory();
        if (StringUtils.isNotEmpty(directory)){
            File file = new File(directory);
            if (!file.exists()){
                file.mkdirs();
            }
            Map<String,String> paramMap = new HashMap<>();
            paramMap.put("dump.directory",directory);
            applicationConfig.setParameters(paramMap);
        }
        return applicationConfig;
    }

    /**
     * dubbo协议配置
     */
    @Bean
    @ConditionalOnMissingBean
    public ProtocolConfig protocolConfig(){
        DubboProperties.Protocol protocol = dubboProperties.getProtocol();
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName(protocol.getName().getName());
        protocolConfig.setPort(protocol.getPort());
        protocolConfig.setThreads(protocol.getThreads());
        protocolConfig.setAccesslog(protocol.getAccesslog().toString());
        if (StringUtils.isNotEmpty(protocol.getServer())){
            protocolConfig.setServer(protocol.getServer());
        }
        String serialization;
        if (StringUtils.isNotBlank(serialization=protocol.getSerialization())){
            protocolConfig.setSerialization(serialization);
        }
        Map<String,String> params;
        if (CollectionUtils.isNotEmpty(params=protocol.getParameters())){
            protocolConfig.setParameters(params);
        }
        String host;
        if (StringUtils.isNotBlank(host = protocol.getHost())){
            protocolConfig.setHost(host);
        }
        return protocolConfig;
    }

    /**
     * dubbo注册中心配置
     */
    @Bean
    @ConditionalOnMissingBean
    public RegistryConfig registryConfig(){
        DubboProperties.Registry registry = dubboProperties.getRegistry();
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress(registry.getAddress());
        registryConfig.setFile(registry.getFile());
        return registryConfig;
    }

    /**
     * dubbo监控中心配置
     */
    @Bean
    @ConditionalOnMissingBean
    public MonitorConfig monitorConfig(){
        DubboProperties.Monitor monitor = dubboProperties.getMonitor();
        MonitorConfig monitorConfig = new MonitorConfig();
        monitorConfig.setAddress(monitor.getAddress());
        monitorConfig.setProtocol(monitor.getProtocol());
        return monitorConfig;
    }

    @Configuration
    @ConditionalOnProperty(prefix = "wujun.dubbo.provider",value = "enable",havingValue = "true")
    @EnableConfigurationProperties(value = DubboProviderProperties.class)
    public static class ProviderConfigAutoConfig{
        @Bean
        public ProviderConfig providerConfig(DubboProviderProperties dubboProviderProperties) {
            ProviderConfig providerConfig = new ProviderConfig();
            providerConfig.setVersion(dubboProviderProperties.getVersion());
            providerConfig.setGroup(dubboProviderProperties.getGroup());
            providerConfig.setTimeout(dubboProviderProperties.getTimeout());
            providerConfig.setExecutes(dubboProviderProperties.getExecutes());
            providerConfig.setLoadbalance(dubboProviderProperties.getLoadbalance());
            providerConfig.setRetries(dubboProviderProperties.getRetries());
            providerConfig.setFilter(dubboProviderProperties.getFilter());
            return providerConfig;
        }
    }

    @Configuration
    @ConditionalOnProperty(prefix = "wujun.dubbo.consumer", value = "enable", havingValue = "true")
    @EnableConfigurationProperties(value = DubboConsumerProperties.class)
    public static class ConsumerConfigAutoConfig {

        @Bean
        public ConsumerConfig consumerConfig(DubboConsumerProperties dubboConsumerProperties) {
            ConsumerConfig consumerConfig = new ConsumerConfig();
            consumerConfig.setCheck(dubboConsumerProperties.getCheck());
            consumerConfig.setTimeout(dubboConsumerProperties.getTimeout());
            consumerConfig.setRetries(dubboConsumerProperties.getRetries());
            consumerConfig.setLoadbalance(dubboConsumerProperties.getLoadbalance());
            consumerConfig.setValidation(dubboConsumerProperties.getValidation());
            consumerConfig.setGroup(dubboConsumerProperties.getGroup());
            consumerConfig.setVersion(dubboConsumerProperties.getVersion());
            return consumerConfig;
        }
    }


}























































