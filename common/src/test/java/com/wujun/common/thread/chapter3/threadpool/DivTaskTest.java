package com.wujun.common.thread.chapter3.threadpool;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author wujun
 * @description
 * @date 19/3/20.
 */
public class DivTaskTest implements Runnable {
    private int a;
    private int b;

    public DivTaskTest(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        double result = a / b;
        System.out.println(result);
    }

    /*public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor pools = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 0L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        for (int i = 0; i < 5; i++) {
            Future re =pools.submit(new DivTaskTest(100, i));
            re.get();
        }
    }*/

    public static void main(String[] args) {
        TraceThreadPoolExecutor pools = new TraceThreadPoolExecutor(0, Integer.MAX_VALUE, 0L, TimeUnit.SECONDS, new SynchronousQueue<>());
        for (int i = 0; i < 5; i++) {
            pools.execute(new DivTaskTest(100, i));
        }
    }
}
