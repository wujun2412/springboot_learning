package com.wujun.common.pattern.decorator;

/**
 * @author wujun
 * @description
 * @date 18/3/19.
 */
public class ConcreteDecorator extends Decorator {

    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void say(String str) {
        System.out.println("准备好了吗?go");
        this.component.say(str);
    }
}
