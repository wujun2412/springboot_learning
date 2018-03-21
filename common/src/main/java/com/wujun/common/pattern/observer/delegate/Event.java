package com.wujun.common.pattern.observer.delegate;

import java.lang.reflect.Method;

/**
 * @author wujun
 * @description 事件对象的封装类
 * @date 18/3/20.
 */
public class Event {
    /**
     * 要执行方法的对象
     */
    private Object object;

    /**
     * 要执行的方法名称
     */
    private String methodName;

    /**
     * 要执行方法的参数
     */
    private Object[] params;

    /**
     * 要执行方法的参数类型
     */
    private Class[] paramTypes;

    public Event() {
    }

    public Event(Object object, String methodName, Object...args) {
        this.object = object;
        this.methodName = methodName;
        this.params = args;
        generateParamTypes(this.params);
    }

    /**
     * 根据参数数组生产参数类型数组
     * @param params
     */
    private void generateParamTypes(Object[] params){
        this.paramTypes = new Class[params.length];
        for (int i = 0; i < params.length; i++) {
            this.paramTypes[i]=params[i].getClass();
        }
    }

    /**
     * 根据该对象方法名，方法参数，利用反射机制，执行该方法
     * @throws Exception
     */
    public void invoke() throws Exception{
        Method method = object.getClass().getMethod(this.methodName,this.getParamTypes());
        if (null == method){
            return ;
        }
        method.invoke(object,this.getParams());
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public Class[] getParamTypes() {
        return paramTypes;
    }

    public void setParamTypes(Class[] paramTypes) {
        this.paramTypes = paramTypes;
    }
}
