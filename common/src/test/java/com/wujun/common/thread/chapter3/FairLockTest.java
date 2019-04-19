package com.wujun.common.thread.chapter3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wujun
 * @description
 * @date 19/3/14.
 */
public class FairLockTest implements Runnable {
    public static ReentrantLock fairLock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            try {
                fairLock.lock();
                System.out.println(Thread.currentThread().getName() + "获得锁");
            } finally {
                fairLock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        FairLockTest f1 = new FairLockTest();
        Thread t1 = new Thread(f1, "thread1");
        Thread t2 = new Thread(f1, "thread2");
        t1.start();
        t2.start();
    }
}
