package com.wujun.common.thread.chapter4;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author wujun
 * @description
 * @date 19/4/8.
 */
public class AtomicIntegerArrayDemo {
    private static AtomicIntegerArray array = new AtomicIntegerArray(10);

    private static class AddThread implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                array.getAndIncrement(i%array.length());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] ts = new Thread[10];
        for (int i = 0; i < 10; i++) {
            ts[i] = new Thread(new AddThread());
        }
        for (int i = 0; i < 10; i++) {
            ts[i].start();
        }
        for (int i = 0; i < 10; i++) {
            ts[i].join();
        }
        System.out.println(array);
    }



}
