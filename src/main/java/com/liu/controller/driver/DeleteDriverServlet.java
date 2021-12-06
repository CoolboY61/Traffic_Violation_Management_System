package com.liu.controller.driver;

import com.liu.service.DriverService;
import com.liu.service.impl.DriverServiceImpl;
import com.liu.util.Constant;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @Author: LiuYi
 * @Date: 2021/7/7 15:51
 */
public class DeleteDriverServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long D_no = Long.parseLong(req.getParameter("D_no"));

        DriverService driverService = new DriverServiceImpl();
        driverService.delete(D_no);

        req.getSession().removeAttribute(Constant.USER_SESSION);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
