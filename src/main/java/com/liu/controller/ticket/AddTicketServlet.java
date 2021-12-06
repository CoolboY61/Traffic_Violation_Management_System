package com.liu.controller.ticket;

import com.liu.dto.Ticket;
import com.liu.service.impl.TicketServiceImpl;
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
 * @Date: 2021/7/7 16:55
 */
public class AddTicketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long T_no = Long.parseLong(req.getParameter("T_no"));
        System.out.println(T_no);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = sdf.parse(req.getParameter("T_date"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date T_date = new Date(date.getTime());
        try {
            date = sdf.parse(req.getParameter("T_time"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date T_time = new Date(date.getTime());
        String T_location = req.getParameter("T_location");
        String T_record = req.getParameter("T_record");
        long T_punishment_warning = Long.parseLong(req.getParameter("T_punishment_warning"));
        long T_punishment_fine = Long.parseLong(req.getParameter("T_punishment_fine"));
        long T_punishment_deduction = Long.parseLong(req.getParameter("T_punishment_deduction"));
        long T_verification = 1;
        long D_no = Long.parseLong(req.getParameter("D_no"));
        long C_no = Long.parseLong(req.getParameter("C_no"));
        long P_no = Long.parseLong(req.getParameter("P_no"));

        Ticket ticket = new Ticket(T_no,T_date,T_time,T_location,T_record,T_punishment_warning,T_punishment_fine,T_punishment_deduction,T_verification,D_no,C_no,P_no);
        TicketServiceImpl ticketService = new TicketServiceImpl();
        ticketService.insert(ticket);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
