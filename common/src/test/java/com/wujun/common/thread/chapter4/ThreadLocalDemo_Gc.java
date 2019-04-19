package com.wujun.common.thread.chapter4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wujun
 * @description
 * @date 19/4/1.
 */
public class ThreadLocalDemo_Gc {
    private static volatile ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected void finalize() throws Throwable {
            System.out.println(this.toString() + " is gc!");
        }
    };

    private static volatile CountDownLatch cd = new CountDownLatch(100);

    private static class ParseDate implements Runnable {
        int i = 0;

        public ParseDate(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                if (threadLocal.get() == null) {
                    threadLocal.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") {
                        @Override
                        protected void finalize() throws Throwable {
                            System.out.println(this.toString() + " is gc");
                        }
                    });
//                    System.out.println(Thread.currentThread().getId() + ":create SimpleDateFormat");
                }
                Date d = threadLocal.get().parse("2019-04-01 11:59:" + i % 60);
                System.out.println(i + ":" + d);
            } catch (ParseException e) {
                e.printStackTrace();
            } finally {
                cd.countDown();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            es.execute(new ParseDate(i));
        }
        cd.await();
        System.out.println("mission complete!!");
        threadLocal = null;
        System.gc();
        System.out.println("first GC complete!!");

        threadLocal = new ThreadLocal<>();
        cd = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            es.execute(new ParseDate(i));
        }
        cd.await();
        Thread.sleep(1000);
        System.gc();
        System.out.println("second GC complete!!");
        es.shutdown();
    }


}
