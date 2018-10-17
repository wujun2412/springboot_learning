package com.wujun.boot.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * @Auther: Jun.Wu
 * @Date: 2018-08-22 15:52
 * @Description:
 */
@WebListener
public class MyListener2 implements HttpSessionAttributeListener {


    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        System.out.println("session attribute add :"+se.getSession().getAttribute("count"));
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        System.out.println("session attribute removed :"+se.getSession().getAttribute("count"));
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        System.out.println("session attribute replaced :"+se.getSession().getAttribute("count"));
    }
}
