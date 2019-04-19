package com.wujun.common.thread.chapter4;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wujun
 * @description
 * @date 19/3/28.
 */
public class ReentrantLockDetailDemo {
    private static final ReentrantLock lock = new ReentrantLock();

    private static class TakeTask implements Runnable {

        @Override
        public void run() {
            try {
                lock.lockInterruptibly();
                System.out.println("Thread: " + Thread.currentThread().getName() + " 获取锁");
                Thread.sleep(300000);
                System.out.println("Thread: " + Thread.currentThread().getName() + " 获取锁结束");
            } catch (Exception e) {
                lock.unlock();
            } finally {
                lock.unlock();
            }
        }
    }

    private static class PutTask implements Runnable {

        @Override
        public void run() {
            try {
                lock.lockInterruptibly();
                System.out.println("Thread: " + Thread.currentThread().getName() + " 获取锁");
            } catch (Exception e) {
                lock.unlock();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new TakeTask(), "thread1");
        Thread t2 = new Thread(new PutTask(), "thread2");
        t1.start();
        Thread.sleep(5000);
        t2.start();
    }


}
