package com.wujun.boot.config.dbconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author wujun
 * @description
 * @date 18/1/19.
 */
@Configuration
public class DataSourceConfiguration {
    private static final Logger log = LoggerFactory.getLogger(DataSourceConfiguration.class);


    @Value("${mysql.datasource.type}")
    private Class<? extends DataSource> dataSourceType;

    /**
     * 写库 数据源配置
     * @return
     */
    @Bean(name = "writeDataSource")
    @Primary
    @ConfigurationProperties(prefix = "mysql.datasource.write")
    public DataSource writeDataSource(){
        log.info("--------------------writeDataSource init--------------------");
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

    /**
     * 从库1
     * @return
     */
    @Bean(name = "readDataSource01")
    @ConfigurationProperties(prefix = "mysql.datasource.read01")
    public DataSource readDataSourceOne(){
        log.info("--------------------readDataSourceOne init--------------------");
        return DataSourceBuilder.create().type(dataSourceType).build();
    }


    @Bean(name = "readDataSource02")
    @ConfigurationProperties(prefix = "mysql.datasource.read02")
    public DataSource readDataSourceTwo(){
        log.info("--------------------readDataSourceOne init--------------------");
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

}
