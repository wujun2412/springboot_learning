package com.wujun.common.thread.chapter5;

/**
 * @author wujun
 * @description
 * @date 19/4/9.
 */
public class Singleton {

    public static int status = 1;

    private Singleton() {
        System.out.println("Singleton is created");
    }

    private static Singleton instance = new Singleton();

    public static Singleton  getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(Singleton.status);
    }
}
























