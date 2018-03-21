package com.wujun.common.pattern.singleton;

/**
 * @author wujun
 * @description 最好的单例模式实现方式（没有之一）
 * 内部类只在需要的时候才会被类加载器加载，实现了懒加载，即在需要的时候才实例化出一个Manager,而且是唯一的一个
 * 同时由于instance是static final类型，保证了内存中只有这样一个实例存在，而且只能被赋值一次，从而保证了线程安全性
 *   （即使在高并发的情况下多个线程同时访问getInstance()方法 也能够保证实例的唯一性）
 * @date 18/3/21.
 */
public class SingletonBest {
    private static SingletonBest instance;

    private SingletonBest(){

    }

    public static SingletonBest getInstance(){
        return InnerClass.instance;
    }

    private static class InnerClass{
        public static final SingletonBest instance = new SingletonBest();
    }


}
