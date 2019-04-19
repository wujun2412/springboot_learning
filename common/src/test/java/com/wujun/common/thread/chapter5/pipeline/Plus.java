package com.wujun.common.thread.chapter5.pipeline;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author wujun
 * @description
 * @date 19/4/9.
 */
public class Plus implements Runnable {
    public static LinkedBlockingQueue<Msg> bq = new LinkedBlockingQueue<>();

    @Override
    public void run() {
        while (true){

            try {
                Msg msg = bq.take();
                msg.j = msg.i + msg.j;
                Multiply.bq.add(msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
