package com.wujun.common.thread.chapter3.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author wujun
 * @description
 * @date 19/3/19.
 */
public class ScheduledExecutorServiceTest {

    public static class Task implements Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println(System.currentTimeMillis()/1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        /*ScheduledExecutorService ses = Executors.newScheduledThreadPool(10);
        ses.scheduleAtFixedRate(new Task(),0,2, TimeUnit.SECONDS);*/

        ScheduledExecutorService ses = Executors.newScheduledThreadPool(10);
        ses.scheduleWithFixedDelay(new Task(),0,2, TimeUnit.SECONDS);
    }

}
