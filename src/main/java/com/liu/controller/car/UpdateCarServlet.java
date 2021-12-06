package com.liu.controller.car;

import com.liu.dto.Car;
import com.liu.dto.Driver;
import com.liu.service.CarService;
import com.liu.service.DriverService;
import com.liu.service.impl.CarServiceImpl;
import com.liu.service.impl.DriverServiceImpl;
import com.liu.util.Constant;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: LiuYi
 * @Date: 2021/7/7 16:34
 */
public class UpdateCarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long C_no = Long.parseLong(req.getParameter("C_no"));
        String C_number = req.getParameter("C_number");
        String C_model = req.getParameter("C_model");
        String C_manufacturer = req.getParameter("C_manufacturer");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        try {
            date = sdf.parse(req.getParameter("C_production_date"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date C_production_date = new Date(date.getTime());
        long D_no = Long.parseLong(req.getParameter("D_no"));
        Car car = new Car(C_no, C_number, C_model, C_manufacturer, C_production_date, D_no);
        CarService carService = new CarServiceImpl();
        carService.update(car);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
