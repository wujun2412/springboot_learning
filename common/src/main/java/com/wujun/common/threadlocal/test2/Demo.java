package com.wujun.common.threadlocal.test2;

/**
 * @author wujun
 * @description
 * @date 18/3/12.
 */
public class Demo {

    public static void main(String[] args) {
        SuperClass clz = new SubClass();
        System.out.println(clz.name);
    }
}
