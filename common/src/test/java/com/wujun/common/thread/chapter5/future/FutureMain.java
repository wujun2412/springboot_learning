package com.wujun.common.thread.chapter5.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author wujun
 * @description
 * @date 19/4/9.
 */
public class FutureMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<String>(new RealData("a"));
        ExecutorService executor = Executors.newFixedThreadPool(1);
        //开始线程进行RealData的call()执行
        executor.submit(futureTask);
        System.out.println("请求完毕");

        try {
            //sleep代替额外的业务逻辑处理
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("业务逻辑处理完成");
        //此时如果call()方法没有执行完成，则依然会等待
        System.out.println("数据：" + futureTask.get());
        executor.shutdown();
    }


}
