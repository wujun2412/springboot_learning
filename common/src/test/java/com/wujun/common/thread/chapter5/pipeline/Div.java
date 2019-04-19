package com.wujun.common.thread.chapter5.pipeline;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author wujun
 * @description
 * @date 19/4/9.
 */
public class Div implements Runnable{
    public static BlockingQueue<Msg> bq = new LinkedBlockingDeque<>();

    @Override
    public void run() {
        while (true){
            try {
                Msg msg = bq.take();
                msg.j = msg.j/2;
                System.out.println(msg.orgStr +"="+ msg.j);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
