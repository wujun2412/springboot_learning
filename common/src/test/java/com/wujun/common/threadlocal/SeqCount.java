package com.wujun.common.threadlocal;

/**
 * @author wujun
 * @description
 * @date 19/2/26.
 */
public class SeqCount {

    private static ThreadLocal<Integer> seqCount = ThreadLocal.withInitial(() -> 0);

    public int nextSeq() {
        seqCount.set(seqCount.get() + 1);
        return seqCount.get();
    }

    public static void main(String[] args) {
        SeqCount seqCount = new SeqCount();

        SeqThread thread1 = new SeqThread(seqCount);
        SeqThread thread2 = new SeqThread(seqCount);
        SeqThread thread3 = new SeqThread(seqCount);
        SeqThread thread4 = new SeqThread(seqCount);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }


}
