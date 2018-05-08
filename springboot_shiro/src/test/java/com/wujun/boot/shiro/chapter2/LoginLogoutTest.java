package com.wujun.boot.shiro.chapter2;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author wujun
 * @description
 * @date 18/4/26.
 */
public class LoginLogoutTest {

    @Test
    public void testHelloWorld(){
        //1、获取 SecurityManager 工厂,此处使用 Ini 配置文件初始化 SecurityManager
        Factory<SecurityManager> factory =new IniSecurityManagerFactory("classpath:shiro-realm.ini");
        //2、得到 SecurityManager 实例 并绑定给 SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //3、得到 Subject 及创建用户名/密码身份验证 Token(即用户身份/凭证)
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");
        //subject.getSession().setAttribute("test",1);

        //System.out.println(subject.getSession().getAttribute("test"));

        try {
            //4、登录,即身份验证
            subject.login(token);
        } catch (AuthenticationException e){
            //身份验证是啊比
        }
        Assert.assertEquals(true,subject.isAuthenticated());
        //6.退出
        subject.logout();
    }




}
