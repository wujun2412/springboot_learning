package com.wujun.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author wujun
 * @description
 * 非Spring管理的实体内使用ApplicationContext还不想采用注入ApplicationContextProvider来完成实例化，
 * 这时我们可以修改ApplicationContext实例对象为静态实例，方法改为静态方法，这样在外部同样是可以获取到指定Bean的实例
 *
 * @date 18/1/11.
 */
@Component
public class ApplicationContextStaticProvider implements ApplicationContextAware {
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static  ApplicationContext getApplicationContext(){
        return context;
    }

    /**
     * 通过beanName获取Bean
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
        return getApplicationContext().getBean(beanName);
    }

    /**
     * 通过class获取bean
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz){
        return getApplicationContext().getBean(clazz);
    }

    /**
     * 通过name,以及Clazz返回指定的bean
     * @param beanName
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(String beanName,Class<T> clazz){
        return getApplicationContext().getBean(beanName,clazz);
    }


}
