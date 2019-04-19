package com.wujun.common.thread.chapter3;

import java.util.concurrent.locks.LockSupport;

/**
 * @author wujun
 * @description
 * @date 19/3/19.
 */
public class LockSupportTest {
    public static Object obj= new Object();

    static Thread t1 = new Thread(new Task(),"t1");
    static Thread t2 = new Thread(new Task(),"t2");

    public static class Task implements Runnable{

        @Override
        public void run() {
             synchronized (obj){
                 System.out.println("in " + Thread.currentThread().getName());
                 LockSupport.park();
                 if (Thread.interrupted()){
                     System.out.println(Thread.currentThread().getName() + " 被中断了");
                 }
                 System.out.println(Thread.currentThread().getName()+" end");
             }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(100);
        t2.start();
        t1.interrupt();
        Thread.sleep(3000);
        LockSupport.unpark(t2);
        t1.join();
        t2.join();
    }
}
