package com.ray.enjoy.spring.mvc.servlet;

import javax.servlet.*;
import java.io.IOException;

public class GreetingFilter implements Filter {

    // tomcat 启动时调用
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("greetingFilter init");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String name = servletRequest.getParameter("name");
        System.out.println("/greeting request param name = " + name);

        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("/greeting response");
    }

    // tomcat 消费时调用
    @Override
    public void destroy() {
        System.out.println("greetingFilter destroy");
        Filter.super.destroy();
    }

}
