package com.wujun.common.thread.chapter3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wujun
 * @description
 * @date 19/3/13.
 */
public class ReentrantLockTest implements Runnable {
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();
    int lock;

    /**
     * 控制加锁顺序，方便构造死锁
     *
     * @param lock
     */
    public ReentrantLockTest(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            if (lock == 1) {
                lock1.lockInterruptibly();
                Thread.sleep(500);
                lock2.lockInterruptibly();
            } else {
                lock2.lockInterruptibly();
                Thread.sleep(500);
                lock1.lockInterruptibly();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock1.isHeldByCurrentThread()){
                lock1.unlock();
            }
            if (lock2.isHeldByCurrentThread()){
                lock2.unlock();
            }
            System.out.println(Thread.currentThread().getId() + ":线程退出");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ReentrantLockTest(1));
        Thread t2 = new Thread(new ReentrantLockTest(2));
        t1.start();
        t2.start();
        Thread.sleep(1000);
        //终端其中一个线程
        t1.interrupt();
    }
}
