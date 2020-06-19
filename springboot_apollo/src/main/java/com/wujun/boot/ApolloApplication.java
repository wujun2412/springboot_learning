package com.wujun.boot;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableApolloConfig
public class ApolloApplication {

	public static void main(String[] args) {
		//System.setProperty("env", "UAT");
		SpringApplication.run(ApolloApplication.class, args);
	}

}
