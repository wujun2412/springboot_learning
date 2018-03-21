package com.wujun.common.pattern.observer.delegate;

/**
 * @author wujun
 * @description
 * @date 18/3/20.
 */
public class GoodNotifier extends Notifier{

    @Override
    public void addListener(Object object, String methodName, Object... args) {
        System.out.println("有新的对象方法需要委托执行!");
        this.getEventHandler().addEvent(object,methodName,args);
    }

    @Override
    public void notifyX() {
        System.out.println("通知需要委托的对象方法执行");
        try {
            this.getEventHandler().notifyX();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
