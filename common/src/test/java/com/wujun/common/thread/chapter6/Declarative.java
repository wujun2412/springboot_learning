package com.wujun.common.thread.chapter6;

import java.util.Arrays;

/**
 * @author wujun
 * @description
 * @date 19/4/10.
 */
public class Declarative {

    public static void main(String[] args) {
        //Declarative();
        //unchange();
        short_code();
    }


    private static void  Declarative(){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void unchange(){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        Arrays.stream(arr).map((x)->x=x+1).forEach(System.out::println);
        System.out.println();
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void short_code(){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        Arrays.stream(arr).map(x->(x%2==0?x:x+1)).forEach(System.out::println);
        System.out.println();
        Arrays.stream(arr).forEach(System.out::println);
    }

}
