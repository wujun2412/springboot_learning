package com.wujun.common.thread.chapter3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wujun
 * @description
 * @date 19/3/14.
 */
public class TimeLockTest implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            if (lock.tryLock(5, TimeUnit.SECONDS)) {
                Thread.sleep(6000);
                System.out.println(Thread.currentThread().getName() + " execute success");
            } else {
                System.out.println(Thread.currentThread().getName() + " get lock failed");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        TimeLockTest tl = new TimeLockTest();
        Thread thread1 = new Thread(tl, "thread1");
        Thread thread2 = new Thread(tl, "thread2");
        thread1.start();
        thread2.start();
    }
}
