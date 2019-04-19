package com.wujun.common.thread.chapter4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wujun
 * @description
 * @date 19/3/28.
 */
public class Test {
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition sinal = lock.newCondition();

    private static class TakeTask implements Runnable {

        @Override
        public void run() {
            try {
                lock.lockInterruptibly();
                System.out.println("Thread: " + Thread.currentThread().getName() + " 获取锁");
                sinal.await();
                System.out.println("Thread: " + Thread.currentThread().getName() + " 获取锁结束");
                //Thread.sleep(5000);
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
                lock.lock();
                System.out.println("Thread: " + Thread.currentThread().getName() + " 获取锁");
                sinal.signal();
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
        Thread.sleep(3000);
        t2.start();
    }


}
