package com.wujun.common.log;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import com.alibaba.dubbo.rpc.RpcContext;

/**
 * @author wujun
 * @description
 * @date 18/2/24.
 */
public class TraceIdConvert extends ClassicConverter {
    private static final String CONVERT = "[@traceId: %s]";
    @Override
    public String convert(ILoggingEvent event) {
        return String.format(CONVERT, RpcContext.getContext().getAttachment("traceId"));
    }
}
