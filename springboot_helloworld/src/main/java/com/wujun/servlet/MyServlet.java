package com.wujun.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 * @author wujun
 * @description
 * @date 18/1/18.
 */
@WebServlet(
        name = "myservlet",
        urlPatterns = "/myservlet",
        initParams = {@WebInitParam(name = "myname",value = "myvalue")}
)
public class MyServlet extends HttpServlet {
    private String value;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        value = config.getInitParameter("myname");
        config.getServletContext().log("servlet init");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        ServletContext servletContext =req.getServletContext();
        servletContext.log("servlet excuting....."+value);
    }

    @Override
    public void destroy() {
        getServletContext().log("servlet destroy");
    }
}
