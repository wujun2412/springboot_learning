package com.wujun.common.thread.chapter4;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author wujun
 * @description
 * @date 19/3/28.
 */
public class LinkedBlockingQueueDemo {
    static final LinkedBlockingQueue queue = new LinkedBlockingQueue(1);

    private static class TakeTask implements Runnable{

        @Override
        public void run() {
            try {
                System.out.println("running take(): "+ queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class PutTask implements Runnable{

        @Override
        public void run() {
            try {
                System.out.println("running put(): " + 1);
                queue.put(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    public static void main(String[] args) throws InterruptedException {
        Thread takeThread = new Thread(new TakeTask());
        Thread putThread = new Thread(new PutTask());
        takeThread.start();
        Thread.sleep(300000);
        putThread.start();
    }
}
