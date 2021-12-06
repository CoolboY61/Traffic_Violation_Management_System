package com.liu.controller.driver;

import com.liu.dto.Driver;
import com.liu.service.DriverService;
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
 * @Date: 2021/7/5 16:47
 */
public class AddDriverServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long D_no = Long.parseLong(req.getParameter("D_no"));
        String D_name = req.getParameter("D_name");
        String D_sex = req.getParameter("D_sex");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = sdf.parse(req.getParameter("D_birthday"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date D_birthday = new Date(date.getTime());
        String D_phone = req.getParameter("D_phone");
        String D_license_number = req.getParameter("D_license_number");
        long D_postcode = Long.parseLong(req.getParameter("D_postcode"));
        String D_address = req.getParameter("D_address");

        Driver driver = new Driver(D_no,D_name,D_sex,D_birthday,D_phone,D_license_number,D_postcode,D_address);
        DriverService driverService = new DriverServiceImpl();
        driverService.insert(driver);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
