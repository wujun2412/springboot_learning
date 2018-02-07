package com.wujun.common.core.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author wujun
 * @description 获取spring上下文对象
 * @date 18/1/11.
 */
@Component
public class ApplicationContextProvider implements ApplicationContextAware {

    /**
     * 上下文对象实例
     */
    private ApplicationContext applicationContext;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 获取 applicationContext
     * @return
     */
    public ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    /**
     * 通过beanName获取Bean
     * @param beanName
     * @return
     */
    public Object getBean(String beanName){
        return getApplicationContext().getBean(beanName);
    }

    /**
     * 通过class获取bean
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getBean(Class<T> clazz){
        return getApplicationContext().getBean(clazz);
    }

    /**
     * 通过name,以及Clazz返回指定的bean
     * @param beanName
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getBean(String beanName,Class<T> clazz){
        return getApplicationContext().getBean(beanName,clazz);
    }

}
