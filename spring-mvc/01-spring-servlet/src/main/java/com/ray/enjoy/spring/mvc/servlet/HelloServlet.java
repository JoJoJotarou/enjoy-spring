package com.ray.enjoy.spring.mvc.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(name = "hello", urlPatterns = {"/hello"}, loadOnStartup = 1)
public class HelloServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        String name = servletRequest.getParameter("name");
        // 响应 hello + name
        servletResponse.getWriter().write("hello " + name);
    }
}
