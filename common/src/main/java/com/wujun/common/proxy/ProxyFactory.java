package com.wujun.common.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author wujun
 * @description cglib动态代理
 * @date 18/2/26.
 */
public class ProxyFactory implements MethodInterceptor {
    private static final String METHOD_PREFIX = "test";

    //维护目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 给目标对象创建一个代理对象
     * @return
     */
    public Object getProxyInstance(){
        //1.工具类
        Enhancer enhancer = new Enhancer();
        //2.设置父类
        enhancer.setSuperclass(target.getClass());
        //3.设置回调函数
        enhancer.setCallback(this);
        //4.创建子类对象(代理对象)
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        /*if (method.getName().startsWith(METHOD_PREFIX)){
            System.out.println("++++++++++开始代理++++++++++");
        }*/

        System.out.println("++++++++++开始代理++++++++++");
        Object obj = method.invoke(target,objects);
        System.out.println("++++++++++结束代理++++++++++");
        return obj;
    }
}
