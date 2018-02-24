package com.wujun.common.dubbo;

import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;
import com.wujun.common.utils.TraceIdUtil;

/**
 * @author wujun
 * @description
 * @date 18/2/24.
 */
@Activate(group = {"consumer"})
public class TraceIdFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        //before filter
        String traceId = TraceIdUtil.getTraceId();
        RpcContext.getContext().setAttachment("traceId",traceId);
        //after filter
        return invoker.invoke(invocation);
    }
}
