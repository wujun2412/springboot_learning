package com.wujun.common.threadlocal;

/**
 * @author wujun
 * @description
 * @date 18/1/17.
 */
public class Child extends Parent {
    static {
        System.out.println("child init!");

    }

    @Override
    public void doTest() {
        System.out.println("父类调用子类方法");
    }
}
