package com.wujun.boot.configuration;

import com.wujun.boot.common.ApplicationResourceName;
import com.wujun.boot.common.RequestUtils;
import com.wujun.boot.filter.PathMatchingPermissionFilter;
import com.wujun.boot.security.MyShiroRealm;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.config.CacheConfiguration;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.AnonymousFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author wujun
 * @description
 * @date 19/4/18.
 */
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 没有登陆的用户只能访问登陆页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        //自定义拦截器
        Map<String, Filter> filtersMap = new LinkedHashMap<String, Filter>();
        //框架白名单
        filtersMap.put("wujun_intranet_anon", new AnonymousFilter() {
            @Override
            protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) {
                if (RequestUtils.isRequestFromIntranet((HttpServletRequest) request)) {
                    return super.onPreHandle(request, response, mappedValue);
                } else {
                    HttpServletResponse servletResponse = (HttpServletResponse) response;
                    try {
                        servletResponse.setContentType("text/html;charset=utf8");
                        servletResponse.getWriter().println("<h1>框架资源只能从内网访问, 请使用\"127.0.0.1\"替代\"localhost\"</h1>");
                    } catch (IOException e) {
                        ; //handled
                    }
                    return false;
                }
            }
        });
        filtersMap.put("wujun_url_mode", pathMatchingPermissionFilter());
        //TODO 限制同一帐号同时在线的个数。
        //filtersMap.put("kickout", kickoutSessionControlFilter());
        shiroFilterFactoryBean.setFilters(filtersMap);
        // 权限控制map.
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        //框架内网访问白名单
        for (String s : ApplicationResourceName.whiteResources()) {
            filterChainDefinitionMap.put(s, "wujun_intranet_anon");
        }
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/img/**", "anon");
        filterChainDefinitionMap.put("/auth/login", "anon");
        filterChainDefinitionMap.put("/auth/logout", "logout");
        filterChainDefinitionMap.put("/auth/kickout", "anon");
        filterChainDefinitionMap.put("/**", "wujun_url_mode");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //这是realm
        securityManager.setRealm(myShiroRealm());
        //自定义缓存实现 使用ehcache
        securityManager.setCacheManager(shiroCacheManager());
        //自定义session管理，使用redis
        //securityManager.setSessionManager(sessionManager());
        return securityManager;
    }

    @Bean
    public MyShiroRealm myShiroRealm() {
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        myShiroRealm.setAuthenticationCachingEnabled(true);
        return myShiroRealm;
    }


    //应用可自定义shiroCacheManager
    @ConditionalOnMissingBean
    @Bean
    public org.apache.shiro.cache.CacheManager shiroCacheManager() {
        EhCacheManager ehCacheManager = new EhCacheManager();
        net.sf.ehcache.config.Configuration configuration = new net.sf.ehcache.config.Configuration();
        CacheConfiguration cacheConfiguration = new CacheConfiguration();
        cacheConfiguration.setMaxEntriesLocalHeap(10000);
        cacheConfiguration.setEternal(false);
        cacheConfiguration.setTimeToIdleSeconds(3600);
        cacheConfiguration.setTimeToLiveSeconds(0);
        cacheConfiguration.setOverflowToDisk(false);
        cacheConfiguration.setStatistics(true);

        configuration.setDefaultCacheConfiguration(cacheConfiguration);
        CacheManager cacheManager = new CacheManager(configuration);
        ehCacheManager.setCacheManager(cacheManager);
        return ehCacheManager;
    }

    /**
     * cacheManager 缓存 redis实现
     * 使用的是shiro-redis开源插件
     *
     * @return
     */
    public RedisCacheManager cacheManager() {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager());
        return redisCacheManager;
    }

    /**
     * 配置shiro redisManager
     * 使用的是shiro-redis开源插件
     *
     * @return
     */
    public RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        redisManager.setHost("localhost");
        redisManager.setPort(6379);
        redisManager.setExpire(1800);// 配置缓存过期时间
        redisManager.setTimeout(0);
        // redisManager.setPassword(password);
        return redisManager;
    }

    /**
     * Session Manager
     * 使用的是shiro-redis开源插件
     */
    @Bean
    public DefaultWebSessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionDAO(redisSessionDAO());
        return sessionManager;
    }

    /**
     * RedisSessionDAO shiro sessionDao层的实现 通过redis
     * 使用的是shiro-redis开源插件
     */
    @Bean
    public RedisSessionDAO redisSessionDAO() {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager());
        return redisSessionDAO;
    }

    /***
     * 授权所用配置
     *
     * @return
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }

    /***
     * 使授权注解起作用不如不想配置可以在pom文件中加入
     * <dependency>
     *<groupId>org.springframework.boot</groupId>
     *<artifactId>spring-boot-starter-aop</artifactId>
     *</dependency>
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * Shiro生命周期处理器
     */
    @Bean
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public PathMatchingPermissionFilter pathMatchingPermissionFilter() {
        return new PathMatchingPermissionFilter(securityManager());
    }
}
