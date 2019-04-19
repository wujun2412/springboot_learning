package com.wujun.common.thread.chapter2;

import java.lang.*;

/**
 * @author wujun
 * @description
 * @date 19/2/26.
 */
public class TestInterrupt2 {

    public static void main(String[] args) throws Exception {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true){
                    System.out.println("Worker started.");
                    if (Thread.currentThread().isInterrupted()){
                        System.out.println("Worker break;");
                        break;
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (java.lang.InterruptedException e) {
                        System.out.println("Worker IsInterrupted: " +
                                Thread.currentThread().isInterrupted());
                    }
                }
                System.out.println("Worker stopped.");
            }
        };
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
        System.out.println("Main thread stopped.");
    }


    public static class Worker implements Runnable {
        public void run() {
            System.out.println("Worker started.");

            try {
                Thread.sleep(500);
            } catch (java.lang.InterruptedException e) {
                System.out.println("Worker IsInterrupted: " +
                        Thread.currentThread().isInterrupted());
            }

            System.out.println("Worker stopped.");
        }
    }
}
