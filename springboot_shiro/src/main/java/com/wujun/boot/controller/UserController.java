package com.wujun.boot.controller;

import com.wujun.common.exceptions.MyLogicExcepion;
import com.wujun.common.responses.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wujun
 * @description
 * @date 19/4/18.
 */
@RestController
@RequestMapping("/user")
@Api(description="shiro 学习")
public class UserController {


    @ApiOperation("登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ApiResult submitLogin(String username, String password) {
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            token.setRememberMe(true);
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
            subject.getSession();
            //SysUser user = (SysUser) subject.getPrincipal();
        } catch (DisabledAccountException e) {
            throw new MyLogicExcepion("账户已被禁用","acount forbiden!");
        } catch (AuthenticationException e) {
            throw new MyLogicExcepion("用户名或密码错误","username or password error!");
        }
        // 执行到这里说明用户已登录成功
        return ApiResult.SUCCESS();
    }


}
