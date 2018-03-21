package com.wujun.common.pattern.observer;

/**
 * @author wujun
 * @description Subject类，可翻译为主题或抽象通知者，一般用一个抽象类或者接口实现。
 * 它把所有对观察者对象的引用保存在一个聚集里，每个主题都可以有任意数量的观察者。抽象主题提供两个接口，可以增加和删除观察者对象
 * @date 18/3/20.
 */
public interface Subject {

    /**
     * 添加观察者
     * @param observer
     */
    public void attach(Observer observer);

    /**
     * 移除观察者
     * @param observer
     */
    public void detach(Observer observer);

    /**
     * 通知观察者
     */
    public void notity();

}
