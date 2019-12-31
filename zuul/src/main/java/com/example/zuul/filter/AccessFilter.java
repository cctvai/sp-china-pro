package com.example.zuul.filter;

import javax.servlet.*;
import javax.servlet.Filter;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * 域名 过滤器
 */
@WebFilter(filterName = "AreaNameFilter",urlPatterns = "/*")
public class AccessFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("zuul time filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("zuul time filter start");

        long time = new Date().getTime();
        //解决跨域核心代码
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "x-requested-with");

        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("zuul time filter :"+(new Date().getTime()-time));
        System.out.println("zuul time filter finish");
    }

    @Override
    public void destroy() {
        System.out.println("zuul time filter destroy");
    }


}
