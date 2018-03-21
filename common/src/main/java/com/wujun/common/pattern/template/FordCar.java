package com.wujun.common.pattern.template;

/**
 * @author wujun
 * @description
 * @date 18/3/20.
 */
public class FordCar extends CarModel {
    @Override
    protected void start() {
        System.out.println("福特 车启动");
    }

    @Override
    protected void stop() {
        System.out.println("福特 车停车");
    }
}
