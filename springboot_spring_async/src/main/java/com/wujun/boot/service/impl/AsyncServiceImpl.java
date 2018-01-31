package com.wujun.boot.service.impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @author wujun
 * @description
 * @date 18/1/31.
 */
@Service
public class AsyncServiceImpl{

    @Async
    public void asyncMethodWithVoidReturnType() {
        System.out.println("Execut method asynchronously. "+Thread.currentThread().getName());
    }

    @Async
    public Future<String> asyncMethodWithReturnType() {
        System.out.println("Execut method asynchronously. "+Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
            return new AsyncResult<>("hello world!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Async("threadPoolTaskExecutor")
    public void asyncMethodWithConfiguredExecutor(){
        System.out.println("Execute method with configured excutor - "+ Thread.currentThread().getName());
    }
}
