package com.wujun.common.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujun
 * @description 具体主题或具体通知者，在具体主题的内部状态改变时，给所有登记过的观察者发出通知
 * @date 18/3/20.
 */
public class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();

    private String status;

    /**
     * 添加观察者
     * @param observer
     */
    @Override
    public void attach(Observer observer){
        observers.add(observer);
    }

    /**
     * 移除观察者
     * @param observer
     */
    @Override
    public void detach(Observer observer){
        observers.remove(observer);
    }

    /**
     * 通知观察者
     */
    @Override
    public void notity(){
        for (Observer observer:observers){
            observer.update();
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
