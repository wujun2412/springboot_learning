package com.wujun.common.test.access;

/**
 * @author wujun
 * @description
 * @date 18/3/2.
 */
public class People {

    private String name ;
    private int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    protected void test(String s){
        System.out.println(s);
    }
}
