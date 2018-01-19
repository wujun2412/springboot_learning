package com.wujun.boot.config.dbconfig;

import com.github.pagehelper.PageInterceptor;
import com.wujun.boot.util.SpringContextUtil;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wujun
 * @description
 * @date 18/1/19.
 */
@Configuration
@AutoConfigureAfter(DataSourceConfiguration.class)
@MapperScan(basePackages = "com.wujun.boot.dao")
public class MyBatisConfiguration {
    private static final Logger log = LoggerFactory.getLogger(MyBatisConfiguration.class);

    @Value("${mysql.datasource.mapperLocations}")
    private String mapperLocation;

    @Value("${mysql.datasource.configLocation}")
    private String configLocation;

    @Value("${mysql.datasource.readSize}")
    private String readDataSourceSize;

    @Autowired
    @Qualifier("writeDataSource")
    private DataSource writeDataSource;

    @Autowired
    @Qualifier("readDataSource01")
    private DataSource readDataSource01;

    @Autowired
    @Qualifier("readDataSource02")
    private DataSource readDataSource02;


    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(PageInterceptor pageInterceptor) throws Exception {
        log.info("-----------------sqlSessionFactory init--------------------");
        try {
            SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
            sessionFactoryBean.setDataSource(roundRobinDataSourceProxy());
            //读取配置
            sessionFactoryBean.setTypeAliasesPackage("com.wujun.boot.domain");
            //设置mapper.xml文件所在位置
            Resource[] resources = new PathMatchingResourcePatternResolver().getResources(mapperLocation);
            sessionFactoryBean.setMapperLocations(resources);
            //这是mybatis-config.xml配置文件位置
            sessionFactoryBean.setConfigLocation(new DefaultResourceLoader().getResource(configLocation));
            //添加分页插件、打印sql插件
            Interceptor[] plugins = new Interceptor[]{ pageInterceptor, new SqlPrintInterceptor()};
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

    /**
     * 把所有数据库都放在路由中
     * @return
     */
    @Bean(name="roundRobinDataSouceProxy")
    public AbstractRoutingDataSource roundRobinDataSourceProxy() {
        Map<Object, Object> targetDataSources = new HashMap<>(8);
        //把所有数据库都放在targetDataSources中,注意key值要和determineCurrentLookupKey()中代码写的一至，
        //否则切换数据源时找不到正确的数据源
        targetDataSources.put(DataSourceType.write.getType(), writeDataSource);
        targetDataSources.put(DataSourceType.read.getType() + "1", readDataSource01);
        targetDataSources.put(DataSourceType.read.getType() + "2", readDataSource02);
        final int readSize = Integer.parseInt(readDataSourceSize);

        AbstractRoutingDataSource proxy = new AbstractRoutingDataSource() {
            private AtomicInteger count = new AtomicInteger(0);
            /**
             * 这是AbstractRoutingDataSource类中的一个抽象方法，
             * 而它的返回值是你所要用的数据源dataSource的key值，有了这个key值，
             * targetDataSources就从中取出对应的DataSource，如果找不到，就用配置默认的数据源。
             */
            @Override
            protected Object determineCurrentLookupKey() {
                String typeKey = DataSourceContextHolder.getReadOrWrite();
                if (typeKey == null) {
                    throw new NullPointerException("数据库路由时，决定使用哪个数据库源类型不能为空...");
                }
                if (typeKey.equals(DataSourceType.write.getType())){
                    System.err.println("使用数据库write.............");
                    return DataSourceType.write.getType();
                }
                //读库， 简单负载均衡
                int number = count.getAndAdd(1);
                int lookupKey = number % readSize;
                System.err.println("使用数据库read-"+(lookupKey+1));
                return DataSourceType.read.getType()+(lookupKey+1);
            }
        };
        proxy.setDefaultTargetDataSource(writeDataSource);
        proxy.setTargetDataSources(targetDataSources);
        return proxy;
    }

    /**
     * 分页插件
     *
     * @return
     */
    @Bean
    public PageInterceptor pageInterceptor() {
        PageInterceptor pageInterceptor = new PageInterceptor();

        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }


    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager(){
        return new DataSourceTransactionManager((DataSource) SpringContextUtil.getBean("roundRobinDataSouceProxy"));
    }
}
