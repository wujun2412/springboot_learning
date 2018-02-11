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
 * @description dubbo服务提供者参数bean
 * @date 18/2/11.
 */
@ConfigurationProperties(prefix = "wujun.dubbo.provider")
@Validated
public class DubboProviderProperties {
    private boolean enable = false;

    // 服务版本
    @NotBlank(message = "dubbo服务提供者的版本不能为空")
    private String version;

    // 服务分组
    @NotBlank(message = "dubbo服务提供者的组不能为空")
    private String group;

    // 远程调用超时时间(毫秒)
    @Min(value = 0, message = "dubbo服务提供者的超时时间不能小于0")
    private int timeout = 20000;

    // 重试次数
    @Min(value = 0, message = "dubbo服务提供者的重试次数不能小于0")
    private int retries = 0;

    // 负载均衡
    @NotBlank(message = "负载均衡策略不能为空")
    private String loadbalance = "roundrobin";

    // 允许执行请求数
    @Min(value = 0, message = "dubbo服务提供者的允许请求数不能小于0")
    private Integer executes = 200;

    @NotEmpty(message = "服务提供者集合不能为空")
    @Valid
    private List<Service> services;

    private String filter = "-accesslog";

    public static class Service {

        @NotNull(message = "dubbo服务提供者的接口类不能为空")
        private Class interfaceClass;

        @NotBlank(message = "dubbo服务提供者的服务引用bean name不能为空")
        private String ref;

        public Class getInterfaceClass() {
            return interfaceClass;
        }

        public void setInterfaceClass(Class interfaceClass) {
            this.interfaceClass = interfaceClass;
        }

        public String getRef() {
            return ref;
        }

        public void setRef(String ref) {
            this.ref = ref;
        }
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
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

    public Integer getExecutes() {
        return executes;
    }

    public void setExecutes(Integer executes) {
        this.executes = executes;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

}
