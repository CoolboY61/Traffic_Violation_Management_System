package com.liu.controller.policemen;

import com.liu.dto.Driver;
import com.liu.dto.Policemen;
import com.liu.service.DriverService;
import com.liu.service.PolicemenService;
import com.liu.service.impl.DriverServiceImpl;
import com.liu.service.impl.PolicemenServiceImpl;
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
 * @Date: 2021/7/7 15:18
 */
public class UpdatePolicemenServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long P_no = Long.parseLong(req.getParameter("P_no"));
        String P_name = req.getParameter("P_name");
        String P_sex = req.getParameter("P_sex");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = sdf.parse(req.getParameter("P_birthday"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date P_birthday = new Date(date.getTime());
        String P_phone = req.getParameter("P_phone");
        long P_numbering = Long.parseLong(req.getParameter("P_numbering"));

        Policemen policemen = new Policemen(P_no,P_name,P_sex,P_birthday,P_phone,P_numbering);
        PolicemenService policemenService = new PolicemenServiceImpl();
        policemenService.update(policemen);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
