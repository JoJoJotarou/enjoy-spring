package com.ray.enjoy.spring.mvc.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "helloFilter", urlPatterns = {"/hello"})
public class HelloFilter implements Filter {

    // tomcat 启动时调用
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("helloFilter init");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String name = servletRequest.getParameter("name");
        System.out.println("/hello request param name = " + name);

        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("/hello response");
    }

    // tomcat 消费时调用
    @Override
    public void destroy() {
        System.out.println("helloFilter destroy");
        Filter.super.destroy();
    }

}
