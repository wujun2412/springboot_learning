package com.wujun.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author: Jun.Wu
 * @Date: 2019-10-28 09:11
 * @Description:
 */
@Configuration
@EnableNeo4jRepositories(basePackages = "com.wujun.boot.dao")
//Neo4j完整的支持ACID，所以此处开启事务功能。
@EnableTransactionManagement
public class Neo4jConfig {
}
