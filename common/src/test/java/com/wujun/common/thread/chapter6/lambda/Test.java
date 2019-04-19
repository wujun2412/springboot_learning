package com.wujun.common.thread.chapter6.lambda;

import java.util.Arrays;
import java.util.function.IntConsumer;

/**
 * @author wujun
 * @description
 * @date 19/4/11.
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        IntConsumer outprintln = System.out::println;
        IntConsumer errprintln = System.err::println;
        //Arrays.stream(arr).forEach(System.out::println);
        Arrays.stream(arr).forEach(outprintln.andThen(errprintln));
    }
}
