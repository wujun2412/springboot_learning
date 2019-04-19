package com.wujun.boot.shiro.chapter2;

import com.wujun.boot.shiro.chapter2.realm.MyRealm1;
import com.wujun.boot.shiro.chapter2.realm.MyRealm2;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.pam.AllSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

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


    @Test
    public void testLoginAndLogout(){
        //1.获取SecurityManager实例，并绑定给SecurityUtils
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        IniRealm realm = new IniRealm("classpath:shiro.ini");
        securityManager.setRealm(realm);

        SecurityUtils.setSecurityManager(securityManager);
        //2.得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");

        try {
            //3.登录
            subject.login(token);
        } catch (AuthenticationException e){
            //4.身份验证失败
        }
        Assert.assertEquals(true,subject.isAuthenticated());
        //6.退出
        subject.logout();
    }

    @Test
    public void testLoginAndLogout2(){
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        // 多realm指定验证规则
        ModularRealmAuthenticator authenticator = new ModularRealmAuthenticator();
        authenticator.setAuthenticationStrategy(new AllSuccessfulStrategy());
        //authenticator.setAuthenticationStrategy(new FirstSuccessfulStrategy());
        securityManager.setAuthenticator(authenticator);
        //IniRealm realm = new IniRealm("classpath:shiro-realm.ini");
        Collection<Realm> realms = new ArrayList<Realm>(1);
        MyRealm1 realm = new MyRealm1();
        MyRealm2 realm2 = new MyRealm2();
        realms.add(realm);
        realms.add(realm2);
        securityManager.setRealms(realms);
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");

        try {
            //3.登录
            subject.login(token);
        } catch (AuthenticationException e){
            //4.身份验证失败
        }
        Assert.assertEquals(true,subject.isAuthenticated());
        //6.退出
        subject.logout();
    }


}
