package com.wujun.common.thread.chapter4;

/**
 * @author wujun
 * @description
 * @date 19/4/4.
 */
public class Test2 {

    public static void main(String[] args) {
        while(true){
            while (true){
                System.out.println("start");
                break;
            }
            System.out.println("end");
        }
    }
}
