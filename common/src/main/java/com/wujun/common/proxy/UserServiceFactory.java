package com.wujun.common.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wujun
 * @description JDK 动态代理
 * @date 18/2/26.
 */
public class UserServiceFactory {
    private static final String METHOD_PREFIX = "test";

    private Object target;

    public UserServiceFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance(){
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().startsWith(METHOD_PREFIX)){
                    System.out.println("+++++++++++代理开始++++++++++++");
                }
                return method.invoke(target,args);
            }
        });
    }
}
