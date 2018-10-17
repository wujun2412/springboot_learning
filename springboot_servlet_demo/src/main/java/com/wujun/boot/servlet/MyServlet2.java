package com.wujun.boot.servlet;

import com.wujun.common.pattern.responsibility.Request;
import org.springframework.core.annotation.Order;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Auther: Jun.Wu
 * @Date: 2018-08-15 15:24
 * @Description:
 */
@WebServlet(urlPatterns = "/myservlet2/",name = "myservlet2")
public class MyServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("myservlet2 doget starting......");
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        System.out.println(session.getId());
        System.out.println(session.getAttribute("sessionkey"));
        System.out.println("myservlet2 dopost starting......");
        resp.setContentType("text/plain");
        PrintWriter out = resp.getWriter();
        out.print("hello myservlet2");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
    }
}
