package com.wujun.common.thread;

/**
 * @author wujun
 * @description
 * @date 18/3/5.
 */
public class ChildThread implements Runnable {
    private static ChildThreadExceptionHandler exceptionHandler;
    static{
        exceptionHandler = new ChildThreadExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(exceptionHandler);
    }

    @Override
    public void run() {
        System.out.println("do something1");
        exceptionMethod();
        System.out.println("do something2");
    }

    public void exceptionMethod(){
        throw new NullPointerException();
    }

    public static class ChildThreadExceptionHandler implements Thread.UncaughtExceptionHandler{

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println(String.format("handle exception in child thread. %s", e));
        }
    }
}
