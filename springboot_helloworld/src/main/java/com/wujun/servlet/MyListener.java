package com.wujun.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * @author wujun
 * @description
 * @date 18/1/18.
 */
@WebListener
public class MyListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        ServletContext servletContext = sre.getServletContext();
        servletContext.log("request init");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        ServletContext servletContext = sre.getServletContext();
        servletContext.log("request destroy");
    }

}
