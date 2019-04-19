package com.wujun.common.thread.chapter2;

/**
 * @author wujun
 * @description
 * @date 19/2/26.
 */
public class TestInterrupt {

    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(){
            @Override
            public void run() {
                int i =0;
                while (true){
                    if (Thread.currentThread().interrupted()){
                        System.out.println("Interrupted: " + isInterrupted());
                        break;
                    }
                    System.out.println("线程运行:"+i++);
                    //Thread.yield();
                }
            }
        };
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();

    }

}
