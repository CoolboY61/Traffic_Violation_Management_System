package com.liu.controller.policemen;

import com.liu.service.PolicemenService;
import com.liu.service.impl.PolicemenServiceImpl;
import com.liu.util.Constant;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @Author: LiuYi
 * @Date: 2021/7/7 16:31
 */
public class DeletePolicemenServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long P_no = Long.parseLong(req.getParameter("P_no"));

        PolicemenService policemenService = new PolicemenServiceImpl();
        policemenService.delete(P_no);

        req.getSession().removeAttribute(Constant.USER_SESSION);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
