package com.liu.controller.car;

import com.liu.service.CarService;
import com.liu.service.impl.CarServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @Author: LiuYi
 * @Date: 2021/7/7 15:32
 */
public class DeleteCarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long C_no = Long.parseLong(req.getParameter("C_no"));
        CarService carService = new CarServiceImpl();
        carService.delete(C_no);

        req.getSession().removeAttribute(req.getParameter("C_no"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
