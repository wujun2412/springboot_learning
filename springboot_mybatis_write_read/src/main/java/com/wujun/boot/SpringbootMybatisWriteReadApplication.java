package com.wujun.boot;

import org.dozer.DozerBeanMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootMybatisWriteReadApplication {

	@Bean("dozerMapper")
	public DozerBeanMapper getDozerBeanMapper(){
		return new DozerBeanMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMybatisWriteReadApplication.class, args);
	}
}
