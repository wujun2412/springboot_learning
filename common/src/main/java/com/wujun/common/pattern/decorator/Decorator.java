package com.wujun.common.pattern.decorator;

/**
 * @author wujun
 * @description 装饰类
 * @date 18/3/19.
 */
public class Decorator implements Component {
    public Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void say(String str) {
        this.component.say(str);
    }
}
