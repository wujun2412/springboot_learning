package com.wujun.common.proxy;

/**
 * @author wujun
 * @description
 * @date 18/2/26.
 */
public class UserService {

    public void test1(){
        System.out.println("执行test1");
        test2();
    }

    public void test2(){
        System.out.println("执行test2");
        test3();
    }

    public void test3(){
        System.out.println("执行test3");
    }

    public void hello(){
        System.out.println("ksdfsdfsdfs");
    }
}
