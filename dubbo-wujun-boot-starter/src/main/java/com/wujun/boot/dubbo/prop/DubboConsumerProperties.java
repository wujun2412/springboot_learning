package com.wujun.boot.dubbo.prop;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author wujun
 * @description dubbo消费方参数bean
 * @date 18/2/11.
 */
@ConfigurationProperties(prefix = "wujun.dubbo.consumer")
@Validated
public class DubboConsumerProperties {
    private boolean enable = false;

    // 检查服务提供者是否存在
    @NotNull(message = "dubbo服务消费者是否检查服务提供者不能为空")
    private Boolean check = Boolean.FALSE;

    // 版本
    @NotBlank(message = "dubbo服务消费者的版本不能为空")
    private String version;

    // 服务分组
    @NotBlank(message = "dubbo服务消费者的分组不能为空")
    private String group;

    // 远程调用超时时间(毫秒)
    @Min(value = 0, message = "dubbo服务消费者的超时时间不能小于0")
    private int timeout = 20000;

    // 重试次数
    @Min(value = 0, message = "dubbo服务消费者的重试次数不能小于0")
    private int retries = 0;

    // 负载均衡
    @NotBlank(message = "dubbo服务消费者的负载均衡策略不能为空")
    private String loadbalance = "roundrobin";

    // 参数校验
    @NotBlank(message = "dubbo服务消费者的参数校验不能为空")
    private String validation = "dubboValidation";

    @NotEmpty(message = "dubbo服务消费者引用的服务列表不能为空")
    @Valid
    private List<Reference> references;

    public static class Reference {

        @NotNull(message = "dubbo消费者引用的服务接口类名称不能为空")
        private Class interfaceClass;

        @NotBlank(message = "dubbo消费者引用的服务bean id不能为空")
        private String beanId;

        /**
         * whether to async
         */
        private Boolean async;

        // --- 这里的group和verison一般不用设置，继承consumer的配置 ---

        private String group;

        private String version;

        public Class getInterfaceClass() {
            return interfaceClass;
        }

        public void setInterfaceClass(Class interfaceClass) {
            this.interfaceClass = interfaceClass;
        }

        public String getBeanId() {
            return beanId;
        }

        public void setBeanId(String beanId) {
            this.beanId = beanId;
        }

        public Boolean getAsync() {
            return async;
        }

        public void setAsync(Boolean async) {
            this.async = async;
        }

        public String getGroup() {
            return group;
        }

        public void setGroup(String group) {
            this.group = group;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getRetries() {
        return retries;
    }

    public void setRetries(int retries) {
        this.retries = retries;
    }

    public String getLoadbalance() {
        return loadbalance;
    }

    public void setLoadbalance(String loadbalance) {
        this.loadbalance = loadbalance;
    }

    public String getValidation() {
        return validation;
    }

    public void setValidation(String validation) {
        this.validation = validation;
    }

    public List<Reference> getReferences() {
        return references;
    }

    public void setReferences(List<Reference> references) {
        this.references = references;
    }
}
