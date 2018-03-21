package com.wujun.common.pattern.observer.delegate;

/**
 * @author wujun
 * @description
 * @date 18/3/20.
 */
public class Test {
    public static void main(String[] args) {
        //创建委托人
        Notifier goodNotifier = new GoodNotifier();
        ListenerA listenerA = new ListenerA();
        ListenerB listenerB = new ListenerB();
        goodNotifier.addListener(listenerA,"stopPlay","足球");
        goodNotifier.addListener(listenerB,"stopWrite","设计模式");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        goodNotifier.notifyX();
    }


}
