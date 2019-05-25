package com.fei.firstspringboot.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: xiaoshijiu
 * @Date: 2019/5/22
 * @Description: 自定义Servlet
 */
public class Myservlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet来了。。。");
        resp.getWriter().write("Myservlet");
    }
}
