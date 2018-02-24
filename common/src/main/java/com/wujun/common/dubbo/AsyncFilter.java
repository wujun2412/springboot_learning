package com.wujun.common.dubbo;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;

/**
 * @author wujun
 * @description dubbo异步传递bug处理 (场景client异步调用serviceA,serviceA同步调用serviceB，serviceB返回的数据永远是空)
 * @date 18/2/24.
 */
@Activate(group = {Constants.PROVIDER})
public class AsyncFilter implements Filter{

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        RpcContext.getContext().removeAttachment(Constants.ASYNC_KEY);
        return invoker.invoke(invocation);
    }
}
