package com.wujun.common.thread.chapter4;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author wujun
 * @description
 * @date 19/4/2.
 */
public class ThreadLocalTest {
    private static final int GEN_COUNT = 10000000;
    private static final int THREAD_COUNT = 4;
    private static ExecutorService es = Executors.newFixedThreadPool(THREAD_COUNT);
    private static Random rnd = new Random(123);

    private static ThreadLocal<Random> tRnd = ThreadLocal.withInitial(() -> new Random(123));

    private static class RndTask implements Callable<Long> {
        private int mode = 0;

        public RndTask(int mode) {
            this.mode = mode;
        }

        private Random getRandom() {
            if (mode == 0) {
                return rnd;
            } else if (mode == 1) {
                return tRnd.get();
            } else {
                return null;
            }
        }

        @Override
        public Long call() throws Exception {
            long b = System.currentTimeMillis();
            for (long i = 0; i < GEN_COUNT; i++) {
                getRandom().nextInt();
            }
            long e = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + " spend " + (e - b) + "ms");
            return e - b;
        }
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<Long>[] futures = new Future[THREAD_COUNT];
        for (int i=0;i<THREAD_COUNT;i++){
            futures[i] = es.submit(new RndTask(0));
        }
        long totalTime = 0;
        for (int i=0;i<THREAD_COUNT;i++){
            totalTime += futures[i].get();
        }
        System.out.println("多线程访问同一个Random实例："+ totalTime +"ms");

        //ThreadLocal的情况
        for (int i=0;i<THREAD_COUNT;i++){
            futures[i] = es.submit(new RndTask(1));
        }
        totalTime = 0;
        for (int i=0;i<THREAD_COUNT;i++){
            totalTime += futures[i].get();
        }
        System.out.println("使用ThreadLocal包装Random实例："+ totalTime +"ms");
        es.shutdown();
    }


}






























