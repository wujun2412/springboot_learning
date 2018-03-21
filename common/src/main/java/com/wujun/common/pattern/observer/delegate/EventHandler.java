package com.wujun.common.pattern.observer.delegate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujun
 * @description 事件的 处理者
 * @date 18/3/20.
 */
public class EventHandler {
    private List<Event> events;

    public EventHandler() {
        this.events = new ArrayList<>();
    }

    /**
     * 添加某个对象要执行的事件，及需要的参数
     * @param object
     * @param methodName
     * @param args
     */
    public void addEvent(Object object,String methodName,Object...args){
        this.events.add(new Event(object,methodName,args));
    }

    /**
     * 通知所有的对象执行指定的事件
     * @throws Exception
     */
    public void notifyX() throws Exception{
        for (Event event:this.events){
            event.invoke();
        }
    }
}
