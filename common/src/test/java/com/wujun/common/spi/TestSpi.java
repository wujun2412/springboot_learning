package com.wujun.common.spi;

import org.junit.Test;

import java.util.ServiceLoader;

/**
 * @author wujun
 * @description
 * @date 18/3/13.
 */
public class TestSpi {
    @Test
    public void test(){
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(Thread.currentThread().getContextClassLoader().getParent());
        System.out.println(Thread.currentThread().getContextClassLoader().getParent().getParent());

        ServiceLoader<ISayName> loaders = ServiceLoader.load(ISayName.class);
        for (ISayName sayName:loaders){
            sayName.sayHello("");
        }
    }

}
