package com.wujun;

/**
 * @author wujun
 * @description
 * @date 18/1/11.
 */
public class Test {

    public static void main(String[] args) {
        int n = 100;
        System.out.println(tableSizeFor(n));
    }


    private static final int tableSizeFor(int c) {
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n;
    }
}
