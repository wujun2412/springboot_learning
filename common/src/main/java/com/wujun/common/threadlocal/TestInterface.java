package com.wujun.common.threadlocal;

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
