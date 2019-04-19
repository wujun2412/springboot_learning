package com.wujun.common.thread.chapter3;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wujun
 * @description
 * @date 19/3/15.
 */
public class CountDownLatchTest implements Runnable{
    static final CountDownLatch end = new CountDownLatch(10);
    static final CountDownLatchTest test = new CountDownLatchTest();

    @Override
    public void run() {
        try {
            //模拟检查任务
            Thread.sleep(new Random().nextInt(10)*1000);
            System.out.println("check complete");
            end.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(10);
        for (int i=0;i<10;i++){
            exec.submit(test);
        }
        //等待检查
        end.await();
        //准备就绪
        System.out.println("fire!");
        exec.shutdown();
    }
}
