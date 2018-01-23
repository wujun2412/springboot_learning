package com.wujun.common.test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wujun
 * @description
 * @date 18/1/16.
 */
public class Test {

    public static void main(String[] args) {
        Map<String,String> map = new ConcurrentHashMap<>(32);
        map.put("String","String");
//        System.out.println(Child.a);
//        Parent[] parents = new Parent[10];
    }

}
