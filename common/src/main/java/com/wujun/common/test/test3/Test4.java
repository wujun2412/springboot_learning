package com.wujun.common.test.test3;

/**
 * @author wujun
 * @description
 * @date 18/4/17.
 */
public class Test4 implements Test3 {
    @Override
    public void print() {
        System.out.println("print");
    }

    @Override
    public void print2() {
        System.out.println("print2");
    }

    public static void main(String[] args) {
        Test4 test = new Test4();
        test.print();
        test.print2();
    }

}
