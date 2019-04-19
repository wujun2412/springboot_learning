package com.wujun.common.thread.chapter2;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author wujun
 * @description
 * @date 19/3/12.
 */
public class JstackCase {
    public static Executor executor = Executors.newFixedThreadPool(5);
    public static Object lock = new Object();

    static class Task implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                calculate();
            }
        }

        public void calculate() {
            int i = 0;
            while (true) {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        Task task1 = new Task();
        Task task2 = new Task();
        executor.execute(task1);
        executor.execute(task2);
    }


}
