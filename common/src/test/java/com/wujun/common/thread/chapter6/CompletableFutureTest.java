package com.wujun.common.thread.chapter6;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author wujun
 * @description
 * @date 19/4/11.
 */
public class CompletableFutureTest {
    private static class AskThread implements Runnable{
        CompletableFuture<Integer> re = null;

        public AskThread(CompletableFuture<Integer> re) {
            this.re = re;
        }

        @Override
        public void run() {
            int result =0;
            try {
                result = re.get()*re.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println(result);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Integer> future = new CompletableFuture<>();
        new Thread(new AskThread(future)).start();
        Thread.sleep(5000);
        future.complete(60);
    }


}
