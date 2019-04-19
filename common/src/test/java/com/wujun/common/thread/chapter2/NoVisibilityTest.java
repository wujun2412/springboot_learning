package com.wujun.common.thread.chapter2;

import java.lang.*;

/**
 * @author wujun
 * @description
 * @date 19/3/13.
 */
public class NoVisibilityTest {
    public volatile static boolean ready;
    public static int number;

    static class Task implements Runnable{
        @Override
        public void run() {
            while (!ready) ;
            System.out.println(number);
        }
    }


    public static void main(String[] args) throws java.lang.InterruptedException {
        Thread thread = new Thread(new Task());
        thread.start();
        Thread.sleep(1000);
        number = 54;
        ready = true;
        Thread.sleep(5000);
    }




}
