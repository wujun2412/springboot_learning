package com.wujun.common.thread.chapter2;

import java.lang.*;

/**
 * @author wujun
 * @description
 * @date 19/3/12.
 */
public class JoinTest {

    public volatile static int i=0;

    public static class AddThread implements Runnable{

        @Override
        public void run() {
            for (i =0;i<100000000;i++);
        }
    }

    public static void main(String[] args) throws java.lang.InterruptedException {
        Thread thread = new Thread(new AddThread());
        thread.start();
        thread.join();
        System.out.println(i);
    }
}
