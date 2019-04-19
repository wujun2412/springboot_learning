package com.wujun.common.threadlocal;

import com.wujun.common.threadlocal.access.People;

/**
 * @author wujun
 * @description
 * @date 18/3/2.
 */
public class Test4 extends People{

    public Test4(String name, int age) {
        super(name, age);
    }

    public static void main(String[] args) {
        /*MyLambdaInterface abc = (s)-> System.out.println(s+s);
        abc.doSomeShit("test");*/

//        Test4 people = new Test4("sdfs",12);
//        people.test("s");
        String str ="127.0.0.1";
        System.out.println(str.hashCode());
    }


}
