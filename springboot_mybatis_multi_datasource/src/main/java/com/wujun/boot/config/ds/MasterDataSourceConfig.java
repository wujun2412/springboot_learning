package com.wujun.boot.config.ds;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @author wujun
 * @description
 * @date 18/1/30.
 */
@Configuration
@MapperScan(basePackages = "com.wujun.boot.dao.master",sqlSessionTemplateRef = "masterSqlSessionTemplate"/*,sqlSessionFactoryRef = "masterSqlSessionFactory"*/)
public class MasterDataSourceConfig {
    private static final Logger log = LoggerFactory.getLogger(MasterDataSourceConfig.class);

    @Value("${mysql.master.type}")
    private Class<? extends DataSource> dataSourceType;

    @Value("${mysql.master.mapperLocations}")
    private String mapperLocation;

    @Value("${mysql.master.configLocation}")
    private String configLocation;

    /**
     * 数据源1配置
     * @return
     */
    @Bean(name = "masterDataSource")
    @Primary
    @ConfigurationProperties(prefix = "mysql.master.datasource")
    public DataSource masterDataSource(){
        log.info("--------------------masterDataSource init--------------------");
        DruidDataSource druidDataSource = (DruidDataSource) DataSourceBuilder.create().type(dataSourceType).build();
        return druidDataSource;
    }

    @Bean(name = "masterSqlSessionFactory")
    @Primary
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource")DataSource masterDataSource) throws Exception {
        log.info("-----------------masterSqlSessionFactory init--------------------");
        try {
            SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
            sessionFactoryBean.setDataSource(masterDataSource);
            //读取配置
            sessionFactoryBean.setTypeAliasesPackage("com.wujun.boot.domain");
            //设置mapper.xml文件所在位置
            Resource[] resources = new PathMatchingResourcePatternResolver().getResources(mapperLocation);
            sessionFactoryBean.setMapperLocations(resources);
            //这是mybatis-config.xml配置文件位置
            sessionFactoryBean.setConfigLocation(new DefaultResourceLoader().getResource(configLocation));
            //添加分页插件、打印sql插件
            Interceptor[] plugins = new Interceptor[]{new SqlPrintInterceptor()};
            sessionFactoryBean.setPlugins(plugins);
            return sessionFactoryBean.getObject();
        } catch (IOException e) {
            log.error("mybatis resolver mapper*xml is error", e);
            return null;
        } catch (Exception e) {
            log.error("mybatis sqlSessionFactoryBean create error", e);
            return null;
        }
    }

    @Bean("masterTransactionManager")
    @Primary
    public DataSourceTransactionManager masterTransactionManager(){
        return new DataSourceTransactionManager(masterDataSource());
    }

    @Bean("masterSqlSessionTemplate")
    public SqlSessionTemplate masterSqlSessionTemplate(@Qualifier("masterSqlSessionFactory")SqlSessionFactory masterSqlSessionFactory){
        return new SqlSessionTemplate(masterSqlSessionFactory);
    }

}
