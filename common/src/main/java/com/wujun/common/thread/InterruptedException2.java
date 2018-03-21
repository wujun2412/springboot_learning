package com.wujun.common.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author wujun
 * @description
 * @date 18/3/5.
 */
public class InterruptedException2 implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(new InterruptedException2(),"InterruptedThread");
        thread.start();
        TimeUnit.SECONDS.sleep(2);
        thread.interrupt();
        System.out.println("InterruptedThread interrupte:"+thread.isInterrupted());
        TimeUnit.SECONDS.sleep(2);
    }
}
