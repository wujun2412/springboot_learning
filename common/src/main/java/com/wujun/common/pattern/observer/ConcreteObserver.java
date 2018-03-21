package com.wujun.common.pattern.observer;

/**
 * @author wujun
 * @description 具体观察者
 * @date 18/3/20.
 */
public class ConcreteObserver extends Observer {
    private String name;
    private ConcreteSubject subject;
    private String observerStatus;

    public ConcreteObserver(String name, ConcreteSubject subject) {
        this.name = name;
        this.subject = subject;
    }

    @Override
    public void update() {
        this.observerStatus = this.subject.getStatus();
        System.out.println("观察者"+name+"的新状态是"+observerStatus);
    }
}
