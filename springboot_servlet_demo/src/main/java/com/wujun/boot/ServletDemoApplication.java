package com.wujun.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class ServletDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServletDemoApplication.class, args);
    }
}
