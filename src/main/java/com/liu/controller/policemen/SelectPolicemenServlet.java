package com.liu.controller.policemen;

import com.liu.dto.Policemen;
import com.liu.service.PolicemenService;
import com.liu.service.impl.PolicemenServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;

import java.io.IOException;

/**
 * @Author: LiuYi
 * @Date: 2021/7/7 16:20
 */
public class SelectPolicemenServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long P_no = Long.parseLong(req.getParameter("P_no"));
        System.out.println(P_no);
        PolicemenService policemenService = new PolicemenServiceImpl();
        Policemen policemen = policemenService.selectByNo(P_no);
        System.out.println(policemen);

        JSONObject json = JSONObject.fromObject(policemen);
        resp.getWriter().append(json.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
