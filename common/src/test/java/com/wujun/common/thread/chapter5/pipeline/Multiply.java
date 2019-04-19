package com.wujun.common.thread.chapter5.pipeline;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author wujun
 * @description
 * @date 19/4/9.
 */
public class Multiply implements Runnable {
    public static BlockingQueue<Msg> bq = new LinkedBlockingDeque<>();
    @Override
    public void run() {
        while (true){
            try {
                Msg msg = bq.take();
                msg.j = msg.i*msg.j;
                Div.bq.add(msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
