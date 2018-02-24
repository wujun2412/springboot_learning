package com.wujun.common.log;

import ch.qos.logback.classic.PatternLayout;

/**
 * @author wujun
 * @description
 * @date 18/2/24.
 */
public class RpcPatternLayout extends PatternLayout {

    static {
        defaultConverterMap.put("traceId",TraceIdConvert.class.getName());

    }
}
