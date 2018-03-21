package com.wujun.common.pattern.observer;

/**
 * @author wujun
 * @description Observer类，抽象观察者，为所有具体观察者定义一个接口，在得到主题通知时更新自己。
 * 抽象观察者一般用一个抽象类或者一个接口实现。
 * @date 18/3/20.
 */
public abstract class Observer {
    public abstract void update();
}
