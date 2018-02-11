package com.wujun.boot.dubbo.prop;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * @author wujun
 * @description
 * @date 18/2/11.
 */
@ConfigurationProperties(prefix = "wujun.dubbo")
@Validated
public class DubboProperties {
    /**
     * 是否开启dubbo自动配置，默认不开启
     */
    private boolean enable = false;

    @NotNull(message = "dubbo的应用配置不能为空")
    @Valid
    private Application application;

    @NotNull(message = "dubbo的协议配置不能为空")
    @Valid
    private Protocol protocol = new Protocol();

    @NotNull(message = "dubbo的注册中心配置不能为空")
    @Valid
    private Registry registry;

    @NotNull(message = "dubbo的监控中心配置不能为空")
    @Valid
    private Monitor monitor;

    /**
     * dubbo应用配置类
     */
    public static class Application {

        @NotBlank(message = "dubbo应用名称不能为空")
        private String name;

        @NotBlank(message = "dubbo应用拥有者不能为空")
        private String owner;

        private String dumpDirectory;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public String getDumpDirectory() {
            return dumpDirectory;
        }

        public void setDumpDirectory(String dumpDirectory) {
            this.dumpDirectory = dumpDirectory;
        }

    }

    /**
     * dubbo协议配置类
     */
    public static class Protocol {

        @NotNull(message = "dubbo协议名不能为空")
        private ProtocolName name = ProtocolName.DUBBO;

        /**
         * 服务IP地址(多网卡时使用)
         */
        private String host;

        @Min(value = 0, message = "dubbo协议端口不能小于0")
        private int port = 20885;

        /**
         * 线程池大小(固定大小)
         */
        @Min(value = 0, message = "dubbo协议线程数量不能小于0")
        private int threads = 200;

        /**
         * 序列化方式
         */
        private String serialization;

        /**
         * 访问日志
         */
        private Boolean accesslog = Boolean.TRUE;

        /**
         * 参数
         */
        private Map<String, String> parameters;

        /**
         * 服务器端实现
         */
        private String server;

        public ProtocolName getName() {
            return name;
        }

        public void setName(ProtocolName name) {
            this.name = name;
        }

        public int getPort() {
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }

        public int getThreads() {
            return threads;
        }

        public void setThreads(int threads) {
            this.threads = threads;
        }

        public String getSerialization() {
            return serialization;
        }

        public void setSerialization(String serialization) {
            this.serialization = serialization;
        }

        public Boolean getAccesslog() {
            return accesslog;
        }

        public void setAccesslog(Boolean accesslog) {
            this.accesslog = accesslog;
        }

        public Map<String, String> getParameters() {
            return parameters;
        }

        public void setParameters(Map<String, String> parameters) {
            this.parameters = parameters;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String getServer() {
            return server;
        }

        public void setServer(String server) {
            this.server = server;
        }

    }

    /**
     * dubbo注册中心配置类
     */
    public static class Registry {

        @NotBlank(message = "dubbo注册中心地址不能为空")
        private String address;

        @NotBlank(message = "dubbo注册中心缓存文件路径不能为空")
        private String file;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }
    }

    /**
     * dubbo监控中心配置类
     */
    public static class Monitor {

        @NotBlank(message = "dubbo监控中心地址不能为空")
        private String address;

        @NotBlank(message = "dubbo监控中心协议不能为空")
        private String protocol = "registry";

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getProtocol() {
            return protocol;
        }

        public void setProtocol(String protocol) {
            this.protocol = protocol;
        }
    }

    /**
     * 协议名称类型
     */
    public enum ProtocolName {
        /**
         * dubbo
         */
        DUBBO("dubbo"),

        /**
         * rmi
         */
        RMI("rmi"),

        /**
         * hessian
         */
        HESSIAN("hessian"),

        /**
         * http
         */
        HTTP("http"),

        /**
         * webservice
         */
        WEBSERVICE("webservice"),

        /**
         * thrift
         */
        THRIFT("thrift"),

        /**
         * memcached
         */
        MEMCACHED("memcached"),

        /**
         * redis
         */
        REDIS("redis");

        private String name;

        public String getName() {
            return name;
        }

        ProtocolName(String name) {
            this.name = name;
        }
    }

    public boolean isEnable() {
        return enable;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }


    public Protocol getProtocol() {
        return protocol;
    }

    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }

    public Registry getRegistry() {
        return registry;
    }

    public void setRegistry(Registry registry) {
        this.registry = registry;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }
}
