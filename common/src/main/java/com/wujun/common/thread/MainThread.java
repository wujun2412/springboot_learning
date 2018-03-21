package com.wujun.common.thread;

/**
 * @author wujun
 * @description
 * @date 18/3/5.
 */
public class MainThread {

    public static void main(String[] args) {
        Thread thread = new Thread(new ChildThread());
        thread.start();
    }

}
