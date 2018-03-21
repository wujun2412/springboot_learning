package com.wujun.common.pattern.template;

/**
 * @author wujun
 * @description
 * @date 18/3/20.
 */
public class AudiCar extends CarModel {
    @Override
    protected void start() {
        System.out.println("奥迪  无匙启动               突突突");
    }

    @Override
    protected void stop() {
        System.out.println("奥迪  停车              ");
    }
}
