package com.wujun.common.pattern.singleton;

/**
 * @author wujun
 * @description 单例模式实现方式： 双重锁定(Double-Check Locking);
 * 懒加载(第一次使用时去初始化)
 * @date 18/3/21.
 */
public class Singleton {
    private static Singleton singleton;
    private static final Object lock = new Object();
    private Singleton(){

    }

    public static Singleton getInstance(){
        if (singleton == null){
            synchronized (lock){
                if (singleton==null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
