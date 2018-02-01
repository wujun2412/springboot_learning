package com.wujun.common.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author wujun
 * @description
 * @date 18/1/16.
 */
public class Test {

    public static void main(String[] args) {
        List<String> list  =   new ArrayList<String>();
        list.add("aaa");
        list.add("bbb");
        list.add("aaa");
        list.add("aba");
        list.add("aaa");

        List newList = new ArrayList(new HashSet(list));
        System.out.println(newList.toString());
    }

}
