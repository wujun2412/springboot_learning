package com.wujun.common.thread;

/**
 * @author wujun
 * @description
 * @date 18/3/5.
 */
public class InterruptedException extends Throwable implements Runnable {
    @Override
    public void run() {

        while (true){
        }
    }


    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(new InterruptedException(),"InterruptedThread");
        thread.start();
        //TimeUnit.SECONDS.sleep(2);
        thread.interrupt();
        System.out.println("InterruptedThread interrupte:"+thread.isInterrupted());
        //TimeUnit.SECONDS.sleep(2);
    }
}
