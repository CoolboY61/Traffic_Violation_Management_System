package com.liu.controller.ticket;

import com.liu.dto.*;
import com.liu.service.CarService;
import com.liu.service.DriverService;
import com.liu.service.PolicemenService;
import com.liu.service.TicketService;
import com.liu.service.impl.CarServiceImpl;
import com.liu.service.impl.DriverServiceImpl;
import com.liu.service.impl.PolicemenServiceImpl;
import com.liu.service.impl.TicketServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: LiuYi
 * @Date: 2021/7/7 17:10
 */
public class SelectTicketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long T_no = Long.parseLong(req.getParameter("T_no"));
        TicketService ticketService = new TicketServiceImpl();
        Ticket ticket = ticketService.select(T_no);
        CarService carService = new CarServiceImpl();
        Car car = carService.select(ticket.getC_no());
        DriverService driverService = new DriverServiceImpl();
        Driver driver = driverService.select(ticket.getD_no());
        PolicemenService policemenService = new PolicemenServiceImpl();
        Policemen policemen = policemenService.selectByNo(ticket.getP_no());

        ViewTicket viewTicket = new ViewTicket(ticket.getT_no(),driver.getD_name(),driver.getD_license_number(),driver.getD_address(),driver.getD_postcode(),driver.getD_phone(),car.getC_number(),car.getC_model(),car.getC_manufacturer(),car.getC_production_date(),ticket.getT_date(),ticket.getT_time(),ticket.getT_location(),ticket.getT_record(),ticket.getT_punishment_warning(),ticket.getT_punishment_fine(),ticket.getT_punishment_deduction(), policemen.getP_name(), policemen.getP_no());
        JSONObject json = JSONObject.fromObject(viewTicket);
        resp.getWriter().append(json.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
