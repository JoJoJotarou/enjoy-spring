package com.ray.springxml;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter(filterName = "myFilter", initParams = {@WebInitParam(name = "filterName", value = "myFilter"), @WebInitParam(name = "filterType", value = "pre")}, urlPatterns = "/*")
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 处理请求：身份验证、授权、数据加密 等
        chain.doFilter(request, response);
        // 处理响应：压缩、数据解密等
    }
}
