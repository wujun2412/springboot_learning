package com.wujun.common.thread.chapter2;

import java.lang.*;

/**
 * @author wujun
 * @description
 * @date 19/3/12.
 */
public class SuspendResumeTest {
    public static Object lock = new Object();
    static Thread thread1 = new Thread(new Task(),"t1");
    static Thread thread2 = new Thread(new Task(),"t2");
    public static class  Task implements Runnable{
        @Override
        public void run() {
            synchronized (lock){
                System.out.println("in "+ Thread.currentThread().getName());
                Thread.currentThread().suspend();
            }
        }
    }

    public static void main(String[] args) throws java.lang.InterruptedException {
        thread1.start();
        Thread.sleep(100);
        thread2.start();
        thread1.resume();
        thread2.resume();
        thread1.join();
        thread2.join();
    }



}
