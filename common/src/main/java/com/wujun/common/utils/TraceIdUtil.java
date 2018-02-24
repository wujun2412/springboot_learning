package com.wujun.common.utils;

/**
 * @author wujun
 * @description dubbo traceId(调用链跟踪ID）工具类
 * @date 18/2/24.
 */
public class TraceIdUtil {
    private static final ThreadLocal<String> TRACE_ID = new ThreadLocal<String>();

    public static String getTraceId(){
        return TRACE_ID.get();
    }

    public static void setTraceId(String traceId){
        TRACE_ID.set(traceId);
    }
}
