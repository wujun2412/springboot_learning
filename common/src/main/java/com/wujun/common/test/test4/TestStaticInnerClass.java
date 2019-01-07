package com.wujun.common.test.test4;

/**
 * @author wujun
 * @description
 * @date 18/12/11.
 */
public class TestStaticInnerClass {

    public static void main(String[] args) {
        Outter outter = Outter.newInner("test").age("12").build();

        System.out.println(outter.getName()+","+outter.getAge());

    }
}
