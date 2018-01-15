package com.wujun.distribute;

/**
 * @author wujun
 * @description
 * @date 18/1/15.
 */
public class Test {


    public static void main(String[] args) {
        Service service = new Service();
        for (int i =0;i<50;i++){
            Thread a = new Thread(new Runnable() {
                @Override
                public void run() {
                    service.seckill();
                }
            });
            a.start();
        }
    }

}
