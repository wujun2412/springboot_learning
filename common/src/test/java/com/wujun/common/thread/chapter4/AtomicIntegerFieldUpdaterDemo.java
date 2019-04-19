package com.wujun.common.thread.chapter4;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author wujun
 * @description
 * @date 19/4/8.
 */
public class AtomicIntegerFieldUpdaterDemo {

    private static class Candidate {
        int id;
        volatile int score;
    }

    private final static AtomicIntegerFieldUpdater<Candidate> scoreUpdater = AtomicIntegerFieldUpdater.newUpdater(Candidate.class, "score");
    //用于检查Updater是否工作正确
    private static AtomicInteger allScore = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        final Candidate stu = new Candidate();
        Thread[] ts = new Thread[10000];
        for (int i = 0; i < 10000; i++) {
            ts[i] = new Thread(() -> {
                if (Math.random()>0.4){
                    scoreUpdater.incrementAndGet(stu);
                    allScore.incrementAndGet();
                }
            });
            ts[i].start();
        }
        for (int i = 0; i < 10000; i++) {
            ts[i].join();
        }

        System.out.println("score="+stu.score);
        System.out.println("allScore="+allScore);
    }


}
