package com.wujun.common.test;

/**
 * @author wujun
 * @description
 * @date 18/4/13.
 */
public interface TestInterface {

    default void test(){
        System.out.println("sdfsdf");
    }

    static void test2(){
        System.out.println("interface static ");
    }

}
