package com.wujun.boot.controller;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.wujun.common.responses.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Jun.Wu
 * @Date: 2020/6/15 16:31
 * @Description:
 */
@RestController
@RequestMapping("/v1/apollo")
public class ApolloController {

/*    @Value( "${com.test:test}" )
    private String test;*/

    @ApolloConfig
    private Config config;


    @GetMapping("/test")
    public ApiResult getApolloParam() {
        return ApiResult.success(config.getProperty("com.test","默认"));
    }

}
