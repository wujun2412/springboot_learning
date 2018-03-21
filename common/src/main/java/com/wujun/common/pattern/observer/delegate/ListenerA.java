package com.wujun.common.pattern.observer.delegate;

/**
 * @author wujun
 * @description
 * @date 18/3/20.
 */
public class ListenerA {

    public ListenerA() {

    }

    public void stopPlay(String gameName){
        System.out.println("停止玩："+gameName);
    }

}
