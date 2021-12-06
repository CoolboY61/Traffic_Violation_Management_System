package com.liu.filter;

import com.liu.util.Constant;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 登录权限过滤器
 * @Author: LiuYi
 * @Date: 2021/7/4 12:09
 */
public class SysFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        // 判断是否已经成功登录，没有则一直返回登录页面
        if (request.getSession().getAttribute(Constant.USER_SESSION) == null) {
            response.sendRedirect("/index.jsp");
        }
        filterChain.doFilter(req,resp);
    }

    @Override
    public void destroy() {
    }
}
