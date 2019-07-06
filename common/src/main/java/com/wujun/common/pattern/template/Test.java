package com.wujun.common.pattern.template;

/**
 * @author wujun
 * @description 模板模式模式
 * @date 18/3/20.
 */
public class Test {

    public static void main(String[] args) {
        CarModel audiCar = new AudiCar();
        CarModel fordCar = new FordCar();
        audiCar.drive();
        fordCar.drive();
    }
}
