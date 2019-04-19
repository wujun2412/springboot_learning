package com.wujun.common.thread.chapter4;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author wujun
 * @description
 * @date 19/4/4.
 */
public class AtomicStampedReferenceDemo {

    private static AtomicStampedReference<Integer> money = new AtomicStampedReference<>(19,0);

    public static void main(String[] args) throws InterruptedException {
        //用户消费线程，模拟消费行为
        new Thread(() ->{
            for (int i = 0; i < 10; i++) {
                while (true){
                    int timeStamp = money.getStamp();
                    Integer m = money.getReference();
                    if (m>10){
                        System.out.println("大于10元");
                        if (money.compareAndSet(m,m-10,timeStamp,timeStamp+1)){
                            System.out.println("成功消费10元，余额："+money.getReference()+" timeStamp:"+timeStamp);
                            break;
                        }
                    }else {
                        System.out.println("没有足够的金额");
                        break;
                    }
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        //模拟多个线程同时更新后台数据库，为用户充值
        for (int i=0;i<3;i++){
            final  int timeStamp = money.getStamp();
            Thread thread =
            new Thread(() -> {
                while (true){
                    while (true){
                        Integer m = money.getReference();
                        if (m<20){
                            if (money.compareAndSet(m,m+20,timeStamp,timeStamp+1)){
                                System.out.println(Thread.currentThread().getId()+"余额小于20元，充值成功，余额:"+money.getReference()+"元, timeStamp:"+timeStamp);
                                break;
                            }
                        }else {
                            //System.out.println(Thread.currentThread().getId()+"充值失败! timeStamp:"+timeStamp);
                            break;
                        }
                    }
                }
            });
            thread.start();
        }


    }




}
