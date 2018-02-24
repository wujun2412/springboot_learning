package com.wujun.boot.manager;

import com.wujun.common.utils.TraceIdUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author wujun
 * @description 拦截请求，传入dubbo traceId
 * @date 18/2/24.
 */
@Component
public class TraceIdInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String traceId = UUID.randomUUID().toString().replace("-","");
        TraceIdUtil.setTraceId(traceId);
        return super.preHandle(request, response, handler);
    }
}
