package com.wujun.common.proxy;

import com.wujun.common.service.UserService;
import com.wujun.common.service.impl.UserServiceImpl;

/**
 * @author wujun
 * @description 只有代理对象proxy直接调用的那个方法才是真正的走代理的！
 * @date 18/1/12.
 */
public class ProxyTest {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        UserServiceProxy proxy = new UserServiceProxy(userService);
        userService= (UserService) proxy.instance();
        userService.test1();
        //userService.test2();

    }
}
