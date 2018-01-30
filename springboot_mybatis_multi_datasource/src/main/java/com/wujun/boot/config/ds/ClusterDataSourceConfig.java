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
@MapperScan(basePackages = "com.wujun.boot.dao.cluster",sqlSessionTemplateRef = "clusterSqlSessionTemplate"/*,sqlSessionFactoryRef = "clusterSqlSessionFactory"*/)
public class ClusterDataSourceConfig {
    private static final Logger log = LoggerFactory.getLogger(ClusterDataSourceConfig.class);

    @Value("${mysql.cluster.type}")
    private Class<? extends DataSource> dataSourceType;

    @Value("${mysql.cluster.mapperLocations}")
    private String mapperLocation;

    @Value("${mysql.cluster.configLocation}")
    private String configLocation;

    /**
     * 数据源1配置
     * @return
     */
    @Bean(name = "clusterDataSource")
    @ConfigurationProperties(prefix = "mysql.cluster.datasource")
    public DataSource clusterDataSource(){
        log.info("--------------------clusterDataSource init--------------------");
        DruidDataSource druidDataSource = (DruidDataSource) DataSourceBuilder.create().type(dataSourceType).build();
        return druidDataSource;
    }

    @Bean(name = "clusterSqlSessionFactory")
    public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("clusterDataSource")DataSource clusterDataSource) throws Exception {
        log.info("-----------------clusterSqlSessionFactory init--------------------");
        try {
            SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
            sessionFactoryBean.setDataSource(clusterDataSource);
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

    @Bean("clusterTransactionManager")
    public DataSourceTransactionManager clusterTransactionManager(){
        return new DataSourceTransactionManager(clusterDataSource());
    }

    @Bean("clusterSqlSessionTemplate")
    public SqlSessionTemplate clusterSqlSessionTemplate(@Qualifier("clusterSqlSessionFactory") SqlSessionFactory clusterSqlSessionFactory){
        return new SqlSessionTemplate(clusterSqlSessionFactory);
    }

}
