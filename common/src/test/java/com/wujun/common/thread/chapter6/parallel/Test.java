package com.wujun.common.thread.chapter6.parallel;

import java.util.Arrays;
import java.util.Random;

/**
 * @author wujun
 * @description
 * @date 19/4/11.
 */
public class Test {

    public static void main(String[] args) {
        int[] arr = {1,9,2,3,10,4,5,6,7,8};
        Random r = new Random();
        Arrays.setAll(arr,(i)->r.nextInt(5));
        Arrays.stream(arr).forEach(System.out::println);
    }
}
