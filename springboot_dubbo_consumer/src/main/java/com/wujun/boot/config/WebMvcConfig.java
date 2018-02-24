package com.wujun.boot.config;

import com.wujun.boot.manager.TraceIdInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author wujun
 * @description 通常情况下，Spring Boot的自动配置是符合我们大多数需求的。
 * 在你既需要保留Spring Boot提供的便利，又需要增加自己的额外的配置的时候，可以定义一个配置类并继承WebMvcConfigurerAdapter,无需使用@EnableWebMvc注解。
 * 参考：https://note.youdao.com/share/index.html?id=bace84b1f9865f426a605e9e514c39f2&type=note#/
 * @date 18/2/24.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private TraceIdInterceptor traceIdInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * addPathPatterns 用于添加拦截规则
         * excludePathPatterns 排除拦截
         * 拦截请求路径以/api打头的所有请求
         */
        registry.addInterceptor(traceIdInterceptor).addPathPatterns("/api/**").excludePathPatterns("/index","/");
        super.addInterceptors(registry);
    }
}
