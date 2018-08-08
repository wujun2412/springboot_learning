package com.wujun.common.proxy;

/**
 * @author wujun
 * @description 只有代理对象proxy直接调用的那个方法才是真正的走代理的！
 * @date 18/1/12.
 */
public class ProxyTest {

    public static void main(String[] args) {
        //1.jdk动态代理
        /*UserService userService = new UserServiceImpl();
        UserServiceProxy proxy = new UserServiceProxy(userService);
        userService= (UserService) proxy.instance();
        userService.test1();*/
        //userService.test2();

        /*UserService userService = new UserServiceImpl();
        UserServiceFactory proxy= new UserServiceFactory(userService);

        userService = (UserService) proxy.getProxyInstance();
        userService.test1();*/



        //2.cglib动态代理
        UserService userService = new  UserService();
        ProxyFactory proxyFactory = new ProxyFactory(userService);
        UserService proxy = (UserService) proxyFactory.getProxyInstance();
        proxy.test1();
        proxy.hello();
    }
}
