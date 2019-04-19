package com.wujun.common.thread.chapter3.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wujun
 * @description
 * @date 19/3/19.
 */
public class ThreadPoolTest {

    public static class Task implements Runnable{
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + ":Thread id:"+Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        Task task = new Task();
        ExecutorService es = Executors.newFixedThreadPool(5);
        //ExecutorService es = Executors.newCachedThreadPool();
        for(int i=0;i<10;i++){
            es.submit(task);
        }
        es.shutdown();
    }

}































