package com.wujun.common.thread.chapter2;

import java.lang.*;

/**
 * @author wujun
 * @description
 * @date 19/3/13.
 */
public class AccountingVol implements Runnable {
    private volatile static int i=0;

    private void increase(){
        i++;
    }

    @Override
    public void run() {
        for (int j=0;j<100000000;j++){
            increase();
        }
    }


    public static void main(String[] args) throws java.lang.InterruptedException {
        AccountingVol vol = new AccountingVol();
        Thread thread1 = new Thread(vol);
        Thread thread2 = new Thread(vol);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(i);
    }
}
