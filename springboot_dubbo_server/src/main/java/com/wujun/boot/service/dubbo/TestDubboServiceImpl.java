package com.wujun.boot.service.dubbo;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.rpc.RpcContext;
import com.wujun.boot.service.TestService;
import com.wujun.boot.service.TestService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wujun
 * @description
 * @date 18/2/11.
 */
@Service("testDubboService")
public class TestDubboServiceImpl implements TestService {
    @Autowired
    private TestService2 testDubboService2;

    @Override
    public String test() {
        String result = "dubbo service test,isAsync:"+RpcContext.getContext().getAttachment(Constants.ASYNC_KEY)+"traceId:"+ RpcContext.getContext().getAttachment("traceId");
        System.out.println(result);
        System.out.println("async传递："+testDubboService2.test());
        return result;
    }
}
