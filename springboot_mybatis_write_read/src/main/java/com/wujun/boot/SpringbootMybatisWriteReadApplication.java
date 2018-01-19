package com.wujun.boot;

import org.dozer.DozerBeanMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//开启事务，并设置order值，默认是Integer的最大值（）
//@EnableTransactionManagement(order = 10)
public class SpringbootMybatisWriteReadApplication {

	@Bean("dozerMapper")
	public DozerBeanMapper getDozerBeanMapper(){
		return new DozerBeanMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMybatisWriteReadApplication.class, args);
	}
}
