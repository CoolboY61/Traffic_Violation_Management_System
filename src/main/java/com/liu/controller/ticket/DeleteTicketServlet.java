package com.liu.controller.ticket;

import com.liu.service.CarService;
import com.liu.service.impl.CarServiceImpl;
import com.liu.service.impl.TicketServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @Author: LiuYi
 * @Date: 2021/7/7 17:08
 */
public class DeleteTicketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long T_no = Long.parseLong(req.getParameter("T_no"));
        TicketServiceImpl ticketService = new TicketServiceImpl();
        ticketService.delete(T_no);

        req.getSession().removeAttribute(req.getParameter("T_no"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
