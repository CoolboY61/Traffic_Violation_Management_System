package com.liu.controller.car;

import com.liu.dto.Car;
import com.liu.dto.Driver;
import com.liu.service.CarService;
import com.liu.service.DriverService;
import com.liu.service.impl.CarServiceImpl;
import com.liu.service.impl.DriverServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;

import java.io.IOException;

/**
 * @Author: LiuYi
 * @Date: 2021/7/7 16:38
 */
public class SelectCarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("C_no"));
        long C_no = Long.parseLong(req.getParameter("C_no"));
        CarService carService = new CarServiceImpl();
        Car car = carService.select(C_no);

        JSONObject json = JSONObject.fromObject(car);
        System.out.println(json.toString());
        resp.getWriter().append(json.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
