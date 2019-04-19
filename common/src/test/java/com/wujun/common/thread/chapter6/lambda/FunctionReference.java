package com.wujun.common.thread.chapter6.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujun
 * @description
 * @date 19/4/11.
 */
public class FunctionReference {

    public static void main(String[] args) {
        List<User> list = new ArrayList<>(8);
        for (int i = 0; i < 8; i++) {
            list.add(new User(i,"name"+i));
        }
        list.stream().map(User::getName).forEach(System.out::println);
    }

}
