package com.wujun.common.test;

/**
 * @author wujun
 * @description
 * @date 18/1/17.
 */
public class Parent {

    static int a = 100;
    static{
        System.out.println("parent init！");
    }

    public void doTest(){

    }

    public void doTest2(){
        doTest();
    }
}
