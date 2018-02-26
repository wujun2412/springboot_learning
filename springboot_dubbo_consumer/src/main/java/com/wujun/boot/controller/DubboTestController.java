package com.wujun.boot.controller;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.service.EchoService;
import com.wujun.boot.service.TestService;
import com.wujun.common.responses.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author wujun
 * @description
 * @date 18/2/23.
 */
@RestController
@RequestMapping("/api")
public class DubboTestController {
    @Autowired
    private TestService testDubboService;

    @RequestMapping("dubbo/test")
    public ApiResult dubboTest(){
        ApiResult result = ApiResult.SUCCESS();
        EchoService echoService = (EchoService) testDubboService;
        RpcContext.getContext().isConsumerSide();
        result.setData(testDubboService.test()+":"+ echoService.$echo("OK"));
        Future<String> testFuture= RpcContext.getContext().getFuture();
        try {
            String test = testFuture.get();
            System.out.println("#########:"+test);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return  result;
    }
}
