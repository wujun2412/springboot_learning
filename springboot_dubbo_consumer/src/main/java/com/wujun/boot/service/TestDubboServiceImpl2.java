package com.wujun.boot.service;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.rpc.RpcContext;
import org.springframework.stereotype.Service;

/**
 * @author wujun
 * @description
 * @date 18/2/11.
 */
@Service("testDubboService2")
public class TestDubboServiceImpl2 implements TestService2 {

    @Override
    public String test() {
        String result = "dubbo service test,isAsync:"+RpcContext.getContext().getAttachment(Constants.ASYNC_KEY)+"traceId:"+ RpcContext.getContext().getAttachment("traceId");
        System.out.println(result);
        return result;
    }
}
