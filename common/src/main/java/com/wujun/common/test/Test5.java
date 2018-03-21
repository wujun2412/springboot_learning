package com.wujun.common.test;

/**
 * @author wujun
 * @description
 * @date 18/3/7.
 */
public class Test5 {

    public static void main(String[] args) {
        //add(5,8);
        String str ="127.0.0.1";
        System.out.println(str.hashCode());

    }
    public static int add(int a,int b){
        int c =a +b;
        int d =c +9;
        return d;
    }
}
