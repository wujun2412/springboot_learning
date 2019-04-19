package com.wujun.common.thread.chapter6.parallel;

import java.util.stream.IntStream;

/**
 * @author wujun
 * @description
 * @date 19/4/11.
 */
public class PrimeTest {

    public static void main(String[] args) {

        serial();
        parallel();
    }

    private static void serial(){
        Long start = System.currentTimeMillis();
        System.out.println(IntStream.range(1,1000000).filter(PrimeUtil::isPrime).count());
        System.out.println("times:"+(System.currentTimeMillis() - start));
    }

    private static void parallel(){
        Long start = System.currentTimeMillis();
        System.out.println(IntStream.range(1,1000000).parallel().filter(PrimeUtil::isPrime).count());
        System.out.println("times:"+(System.currentTimeMillis() - start));
    }
}
