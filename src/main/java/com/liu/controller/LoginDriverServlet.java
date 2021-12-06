package com.liu.controller;

import com.liu.dto.Driver;
import com.liu.service.DriverService;
import com.liu.service.impl.DriverServiceImpl;
import com.liu.util.Constant;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: LiuYi
 * @Date: 2021/7/5 11:08
 */
public class LoginDriverServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        // 和数据库中的数据进行比较，调用业务层
        DriverService driverService = new DriverServiceImpl();
        Driver driver = driverService.login(name);
        String status = "success!";
        PrintWriter out = resp.getWriter();
        if (driver.getD_name().equals(name) && driver.getD_phone().equals(phone)) {
            // 将用户的信心放入Session中
            out.write(status);
            req.getSession().setAttribute(Constant.USER_SESSION,driver);

            out.flush();
        } else {
            // 转发到登录页面,顺带提醒用户，用户名手机号错误

            req.getRequestDispatcher("index,jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
