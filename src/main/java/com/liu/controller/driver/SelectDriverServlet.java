package com.liu.controller.driver;

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
 * @Date: 2021/7/7 15:58
 */
public class SelectDriverServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long D_no = Long.parseLong(req.getParameter("D_no"));
        DriverService driverService = new DriverServiceImpl();
        Driver driver = driverService.select(D_no);


        JSONObject json = JSONObject.fromObject(driver);
        resp.getWriter().append(json.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
