package com.wujun.common.pattern.decorator;

/**
 * @author wujun
 * @description
 * @date 18/3/19.
 */
public class Main {

    public static void main(String[] args) {
        //使用装饰器
        Component component = new ConcreteDecorator(new ConcreteComponent());

        component.say("hello");
    }

}
