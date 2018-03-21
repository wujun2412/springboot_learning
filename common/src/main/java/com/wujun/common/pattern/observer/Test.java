package com.wujun.common.pattern.observer;

/**
 * @author wujun
 * @description
 * @date 18/3/20.
 */
public class Test {

    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        subject.attach(new ConcreteObserver("A",subject));
        subject.attach(new ConcreteObserver("B",subject));
        subject.setStatus("ABC");
        subject.notity();

    }

}
