package com.wujun.boot.controller;

import com.wujun.common.responses.ApiResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wujun
 * @description
 * @date 18/2/9.
 */
@RestController
@RequestMapping("/gatling")
public class GatlingController {


    @GetMapping("/test")
    public ApiResult test(){
        return ApiResult.SUCCESS();
    }

}
