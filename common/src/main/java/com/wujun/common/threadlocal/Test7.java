package com.wujun.common.threadlocal;

/**
 * @author wujun
 * @description
 * @date 18/6/12.
 */
public class Test7 {
    public static void main(String[] args) {
        String c = "123";
        String d = "123" + "123";
        String e = "123" + c;
        System.out.println(d == e);
    }
}
