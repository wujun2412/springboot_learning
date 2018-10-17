package com.wujun.boot.servlet;

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
 * @Date: 2018-08-14 10:23
 * @Description:
 */
@WebServlet(urlPatterns = "/myservlet/",name = "myservlet")
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("myservlett doget starting......");
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        System.out.println(session.getId());
        session.setAttribute("sessionkey","session");
        resp.setBufferSize(10240);
        resp.setHeader("test","headTest");
        resp.addHeader("test","headTest2");
        System.out.println("myservlett dopost starting......");
        resp.setContentType("text/plain");
        PrintWriter out = resp.getWriter();
        resp.sendError(404);
        out.print("hello myservlet");
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
