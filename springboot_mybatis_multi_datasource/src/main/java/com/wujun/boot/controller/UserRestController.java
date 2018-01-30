package com.wujun.boot.controller;

import com.wujun.boot.domain.User;
import com.wujun.boot.service.UserService;
import com.wujun.common.responses.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wujun
 * @description
 * @date 18/1/30.
 */
@RestController
@RequestMapping("/api")
public class UserRestController {
    @Autowired
    private UserService userService;



    @PostMapping(value = "/user")
    public ApiResult<User> findByUserName(@RequestParam(value = "userName",required = true)String userName){
        User user = userService.findByName(userName);
        ApiResult apiResult= ApiResult.SUCCESS();
        apiResult.setData(user);
        return apiResult;
    }

}
