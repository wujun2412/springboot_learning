package com.wujun.boot.aop;

import com.wujun.boot.config.dbconfig.DataSourceContextHolder;
import com.wujun.boot.config.dbconfig.DataSourceType;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

/**
 * @author wujun
 * @description
 * 在service层决定数据源
 *
 * 必须在事务AOP之前执行，所以实现Ordered,order的值越小，越先执行
 * 如果一旦开始切换到写库，则之后的读都会走写库
 * @date 18/1/19.
 */
@Aspect
//开启AspectJ 自动代理模式,如果不填proxyTargetClass=true，默认为false，
//即使用jdk默认代理模式，AspectJ代理模式是CGLIB代理模式
//如果目标对象实现了接口，默认情况下会采用JDK的动态代理实现AOP
//如果目标对象实现了接口，可以强制使用CGLIB实现AOP (此例子我们就是强制使用cglib实现aop)
//如果目标对象没有实现了接口，必须采用CGLIB库，spring会自动在JDK动态代理和CGLIB之间转换
@EnableAspectJAutoProxy(exposeProxy = true,proxyTargetClass = true)
@Component
public class DataSourceAopInService implements PriorityOrdered {


    @Before("execution(* com.wujun.boot.service..*.*(..)) "
            + " and @annotation(com.wujun.boot.annotation.ReadDataSource) ")
    public void setReadDataSourceType() {
        //如果已经开启写事务了，那之后的所有读都从写库读
        if(!DataSourceType.write.getType().equals(DataSourceContextHolder.getReadOrWrite())){
            DataSourceContextHolder.setRead();
        }

    }

    @Before("execution(* com.wujun.boot.service..*.*(..)) "
            + " and @annotation(com.wujun.boot.annotation.WriteDataSource) ")
    public void setWriteDataSourceType() {
        DataSourceContextHolder.setWrite();
    }


    @Override
    public int getOrder() {
        /**
         * 值越小，越优先执行
         * 要优于事务的执行
         * 在启动类中加上了@EnableTransactionManagement(order = 10)
         */
        return 1;
    }
}
