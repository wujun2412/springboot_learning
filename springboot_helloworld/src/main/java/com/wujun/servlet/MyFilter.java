package com.wujun.servlet;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author wujun
 * @description
 * @date 18/1/18.
 */
@WebFilter(servletNames = "myservlet")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext servletContext =filterConfig.getServletContext();
        servletContext.log("init filter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ServletContext servletContext = request.getServletContext();
        servletContext.log("do filter");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        System.out.println("destroy filter");
    }
}
