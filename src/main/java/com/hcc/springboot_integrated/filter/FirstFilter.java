package com.hcc.springboot_integrated.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 整合Filter
 *
 * @ClassName FirstFilter
 * @Description TODO
 * @Author Abel
 * @Date 2019/5/7 16:19
 * @Version 1.0
 **/
@WebFilter(filterName = "FirstFilter",urlPatterns = "/firstFilter")
public class FirstFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("进入filter");
        chain.doFilter(request, response);
        System.out.println("离开filter");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter初始化");
    }

    @Override
    public void destroy() {
        System.out.println("filter销毁");
    }
}
