package com.wujun.common.threadlocal;

/**
 * @author wujun
 * @description
 * @date 19/2/26.
 */
public class SeqThread extends Thread {
    private SeqCount seqCount;

    SeqThread(SeqCount seqCount) {
        this.seqCount = seqCount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " seqCount: " + seqCount.nextSeq());
        }
    }
}
