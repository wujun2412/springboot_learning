package com.wujun.boot.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @Auther: Jun.Wu
 * @Date: 2018-08-22 14:59
 * @Description:
 */
@WebListener
public class MyListener implements HttpSessionListener {
    private int count = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        count ++;
        se.getSession().setAttribute("count",count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        count --;
        se.getSession().setAttribute("count",count);
    }
}
