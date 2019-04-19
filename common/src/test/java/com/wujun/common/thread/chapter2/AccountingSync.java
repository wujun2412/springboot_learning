package com.wujun.common.thread.chapter2;

/**
 * @author wujun
 * @description
 * @date 19/3/13.
 */
public class AccountingSync implements Runnable {
    private static AccountingSync instance = new AccountingSync();
    private static int i=0;

    private synchronized void increase(){
            i++;
    }

    @Override
    public void run() {
        for (int j=0;j<10000000;j++){
            increase();
        }
    }


    public static void main(String[] args) throws java.lang.InterruptedException {
        Thread thread1 = new Thread(instance,"thread1");
        Thread thread2 = new Thread(instance,"thread2");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(i);
    }
}
