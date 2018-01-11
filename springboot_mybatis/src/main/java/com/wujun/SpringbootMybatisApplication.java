package com.wujun;

import org.dozer.DozerBeanMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
// mapper 接口类扫描包配置
@MapperScan("com.wujun.dao")
public class SpringbootMybatisApplication {

	@Bean("dozerMapper")
	public DozerBeanMapper getDozerBeanMapper(){
		return new DozerBeanMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMybatisApplication.class, args);
	}
}
