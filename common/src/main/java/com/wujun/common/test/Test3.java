package com.wujun.common.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wujun
 * @description
 * @date 18/2/6.
 */
public class Test3 {


    public static void main(String[] args) {
        List<String> list1 =new ArrayList<>(Arrays.asList("1","2","3"));
        List<String> list2 =Arrays.asList("4","5","6");

        list1.addAll(list2);

        System.out.println(list1.toString());
    }
}
