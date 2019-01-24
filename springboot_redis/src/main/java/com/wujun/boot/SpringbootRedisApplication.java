package com.wujun.boot;

import com.wujun.common.core.context.ApplicationContextStaticProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"com.wujun.common.core.exception","com.wujun.boot"})
public class SpringbootRedisApplication {

    @Bean
    public ApplicationContextStaticProvider applicationContextStaticProvider() {
        return new ApplicationContextStaticProvider();
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringbootRedisApplication.class, args);
    }
}
