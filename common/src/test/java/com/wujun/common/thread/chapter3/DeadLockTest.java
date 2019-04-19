package com.wujun.common.thread.chapter3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wujun
 * @description
 * @date 19/3/14.
 */
public class DeadLockTest implements Runnable {
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();

    int lock;

    public DeadLockTest(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        if (lock == 1) {
            while (true) {
                lock1.lock();
                try {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock2.lock();
                    try {
                        System.out.println(Thread.currentThread().getName() + " :My Job done");
                        return;
                    } finally {
                        lock2.unlock();
                    }
                } finally {
                    lock1.unlock();
                }
            }
        } else {
            while (true) {
                lock2.lock();
                try {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock1.lock();
                    try {
                        System.out.println(Thread.currentThread().getName() + " :My Job done");
                        return;
                    } finally {
                        lock1.unlock();
                    }
                } finally {
                    lock2.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        DeadLockTest l1 = new DeadLockTest(1);
        DeadLockTest l2 = new DeadLockTest(2);
        Thread thread1 = new Thread(l1);
        Thread thread2 = new Thread(l2);
        thread1.start();
        thread2.start();

    }
}
