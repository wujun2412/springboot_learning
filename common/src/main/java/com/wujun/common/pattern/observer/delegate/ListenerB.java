package com.wujun.common.pattern.observer.delegate;

/**
 * @author wujun
 * @description
 * @date 18/3/20.
 */
public class ListenerB {

    public ListenerB() {

    }

    public void stopWrite(String bookName){
        System.out.println("停止写："+bookName);
    }

}
