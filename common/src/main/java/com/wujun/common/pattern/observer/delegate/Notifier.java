package com.wujun.common.pattern.observer.delegate;

/**
 * @author wujun
 * @description 通知者的抽象类
 * @date 18/3/20.
 */
public abstract class Notifier {

    private EventHandler eventHandler = new EventHandler();

    public EventHandler getEventHandler() {
        return eventHandler;
    }

    public void setEventHandler(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    /**
     * 添加需要通知的对象方法
     * @param object
     * @param methodName
     * @param args
     */
    public abstract void addListener(Object object, String methodName,Object...args);

    /**
     * 执行需要通知的对象的方法
     */
    public abstract void notifyX();

}
