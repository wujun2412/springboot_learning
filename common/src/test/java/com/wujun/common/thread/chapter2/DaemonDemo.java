package com.wujun.common.thread.chapter2;

import java.lang.*;
import java.lang.InterruptedException;

/**
 * @author wujun
 * @description
 * @date 19/3/13.
 */
public class DaemonDemo {

    public static class Task implements Runnable{

        @Override
        public void run() {
            while (true){
                System.out.println("I am alive");
                try {
                    Thread.sleep(1000);
                } catch (java.lang.InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Task());
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(2000);
    }

}
