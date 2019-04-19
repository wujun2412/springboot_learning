package com.wujun.common.thread.chapter3;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author wujun
 * @description
 * @date 19/3/15.
 */
public class ReadWriteLockDemo {
    private static Lock lock = new ReentrantLock();
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();

    private int value;

    public Object handleRead(Lock lock) throws InterruptedException {
        try {
            lock.lock();
            //模拟读操作，读操作的耗时越多，读写锁的优势越明显
            Thread.sleep(1000);
            System.out.println(value);
            return value;
        } finally {
            lock.unlock();
        }
    }

    public void handleWrite(Lock lock, int index) throws InterruptedException {
        try {
            lock.lock();
            //模拟写操作
            Thread.sleep(1000);
            value = index;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final ReadWriteLockDemo demo = new ReadWriteLockDemo();
        Runnable readRunnable = () -> {
            try {
                //demo.handleRead(readLock);
                demo.handleRead(lock);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable writeRunnable = () -> {
            try {
                demo.handleWrite(lock, new Random().nextInt());
                //demo.handleWrite(writeLock, new Random().nextInt());
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        for (int i=0;i<18;i++){
            new Thread(readRunnable).start();
        }

        for(int i=18;i<20;i++){
            new Thread(writeRunnable).start();
        }

        System.out.println("sdfsfd");
    }


}
