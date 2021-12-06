package com.liu.filter;


import jakarta.servlet.*;

import java.io.IOException;

/**
 * 字符编码过滤器
 * @Author: LiuYi
 * @Date: 2021/7/4 9:14
 */
public class CharacterEncodingFilter implements Filter {
    /**
     * 初始化
     * @param filterConfig
     * @throws ServletException
     *
     * web服务器启动，就已经初始化了，随时等待过滤对象的出现
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    /**
     * 过滤
     * @param servletRequest 请求
     * @param servletResponse 响应
     * @param filterChain 链
     * @throws IOException
     * @throws ServletException
     * Chain：链
     * 1. 过滤中的所有代码，在过滤特定请求时都会执行
     * 2. 必须要让过滤器继续通行
     * filterChain.doFilter(servletRequest,servletResponse);
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=UTF-8");

        // 让我们的请求继续走，如果不写，程序到这里会被拦截停止！
        filterChain.doFilter(servletRequest,servletResponse);
    }
    /**
     * 销毁
     */
    @Override
    public void destroy() {

    }
}
