package com.wujun.service.impl;

import com.wujun.service.UserService;

/**
 * @author wujun
 * @description
 * @date 18/1/12.
 */
public class UserServiceImpl implements UserService {
    @Override
    public void test1() {
        System.out.println("--执行test1--");

        test2();
    }

    @Override
    public void test2() {
        System.out.println("--执行test2--");
        test3();
    }

    @Override
    public void test3() {
        System.out.println("--执行test3--");
    }
}
