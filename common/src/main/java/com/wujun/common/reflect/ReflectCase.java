package com.wujun.common.reflect;

import java.lang.reflect.Method;

/**
 * @author wujun
 * @description
 * @date 18/1/25.
 */
public class ReflectCase {

    public static void main(String[] args) throws Exception {
        Proxy proxy = new Proxy();
        Method method = Proxy.class.getDeclaredMethod("run");

        method.invoke(proxy);
    }

    static class Proxy{
        public void run(){
            System.out.println("run'");
        }

    }

}
