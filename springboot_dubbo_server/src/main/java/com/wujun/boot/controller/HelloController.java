package com.wujun.boot.controller;

import com.wujun.common.responses.ApiResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wujun
 * @description
 * @date 18/2/11.
 */
@RestController
@RequestMapping("/dubbo")
public class HelloController {
    @Value("${wujun.test}")
    private String test;

    @Value("${wujun.test2}")
    private String test2;


    @RequestMapping("/test")
    public ApiResult test(){
        ApiResult apiResult = ApiResult.SUCCESS();
        apiResult.setData(test+test2);
        return apiResult;
    }
}
