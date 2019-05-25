package com.fei.firstspringboot.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author: xiaoshijiu
 * @Date: 2019/5/22
 * @Description: 自定义过滤器
 */
public class MyFilter extends HttpFilter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("Filter----before");
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        System.out.println(servletRequest.getRequestURI());
        chain.doFilter(request,response);
        System.out.println("Filter----after");
    }
}
