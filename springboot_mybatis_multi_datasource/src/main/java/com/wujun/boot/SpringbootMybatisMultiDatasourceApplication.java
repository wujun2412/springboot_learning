package com.wujun.boot;

import org.dozer.DozerBeanMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootMybatisMultiDatasourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMybatisMultiDatasourceApplication.class, args);
	}

	@Bean("dozerMapper")
	public DozerBeanMapper getDozerBeanMapper(){
		return new DozerBeanMapper();
	}
}
