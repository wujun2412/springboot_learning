package com.wujun.common.threadlocal;

/**
 * @author wujun
 * @description
 * @date 18/12/27.
 */
public class Test8 {

    public static void main(String[] args) {
        test();
    }


    public static void test(){
        while (test2()){
            System.out.println("sdfsdf");
            break;
        }

        System.out.println("end");
    }

    public static boolean test2(){
        System.out.println("sfsdfsdf");
        return true;
    }
}

































