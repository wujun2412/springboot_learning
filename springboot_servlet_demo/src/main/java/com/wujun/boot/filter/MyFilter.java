package com.wujun.boot.filter;

import com.wujun.common.utils.ListUtil;
import org.springframework.core.annotation.Order;

import javax.naming.Name;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

/**
 * @Auther: Jun.Wu
 * @Date: 2018-08-14 17:13
 * @Description:
 */
@WebFilter(/*urlPatterns = "/myservlet/"*/
        servletNames = {"myservlet","myservlet2"},
        initParams = {@WebInitParam(name = "test",value = "testValue"),
                      @WebInitParam(name="test2",value = "testValue2")})
@Order(1)
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Enumeration<String> params =  filterConfig.getInitParameterNames();
        List<String> list = Collections.list(params);
        if(!ListUtil.isEmpty(list)){
            for (String name:list){
                System.out.println(filterConfig.getInitParameter(name));
            }
        }
        System.out.println("过滤器初始化。。。");

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("过滤器执行。。。");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁。。。");
    }
}
