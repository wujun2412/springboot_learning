package com.wujun.boot.controller;

import com.alibaba.dubbo.rpc.service.EchoService;
import com.wujun.boot.service.TestService;
import com.wujun.common.responses.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wujun
 * @description
 * @date 18/2/23.
 */
@RestController
@RequestMapping("/dubbo")
public class DubboTestController {
    @Autowired
    private TestService testDubboService;

    @RequestMapping("/test")
    public ApiResult dubboTest(){
        ApiResult result = ApiResult.SUCCESS();
        EchoService echoService = (EchoService) testDubboService;
        result.setData(testDubboService.test()+":"+ echoService.$echo("OK"));
        return  result;
    }
}
