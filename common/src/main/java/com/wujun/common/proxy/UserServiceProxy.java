package com.wujun.common.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wujun
 * @description JDK动态代理
 * @date 18/1/12.
 */
public class UserServiceProxy implements InvocationHandler{
    private static final String METHOD_PREFIX="test";

    private Object target;

    public UserServiceProxy(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //使用这个标志来识别是否使用代理还是使用方法本体
        if (method.getName().startsWith(METHOD_PREFIX)){
            System.out.println("+++++++++分隔符+++++++++++");
        }

        return method.invoke(target,args);
    }

    public Object instance(){
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),target.getClass().getInterfaces(),this);
    }
}
