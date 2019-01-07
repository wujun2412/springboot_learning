package com.wujun.boot.test;

import org.quartz.utils.Key;

import java.util.UUID;

/**
 * @author wujun
 * @description
 * @date 19/1/3.
 */
public class Test1 {


    public static void main(String[] args) {
        String group = "DEFAULT";
        String n1 = UUID.randomUUID().toString();
        String n2 = UUID.nameUUIDFromBytes(group.getBytes()).toString();
        System.out.println(String.format("%s=%s", n2.substring(24), n1));
        System.out.println(Key.createUniqueName(null));
    }


}
