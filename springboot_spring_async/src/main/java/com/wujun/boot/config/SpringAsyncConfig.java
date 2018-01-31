package com.wujun.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @author wujun
 * @description
 * @date 18/1/31.
 */
@Configuration
@EnableAsync
public class SpringAsyncConfig{

    @Bean(name = "threadPoolTaskExecutor" )
    public Executor threadPoolTaskExecutor(){
        return new ThreadPoolTaskExecutor();
    }

}
