package com.liu.dao.impl;

import com.liu.dto.ViewTicket;
import com.liu.util.BaseDao;
import com.liu.dao.TicketDao;
import com.liu.dto.Ticket;

import java.sql.Connection;
import java.util.List;

/**
 * @Author: LiuYi
 * @Date: 2021/7/4 22:38
 */
public class TicketDaoImpl extends BaseDao implements TicketDao {
    @Override
    public void insert(Connection conn, Ticket ticket) {
        String sql = "insert into ticket(T_no,T_date,T_time,T_location,T_record,T_punishment_warning,T_punishment_fine,T_punishment_deduction,T_verification,D_no,C_no,P_no) " +
                "values(?,?,?,?,?,?,?,?,?,?,?,?)";
        updateResources(conn,sql,ticket.getT_no(),ticket.getT_date(),ticket.getT_time(),ticket.getT_location(),ticket.getT_record(),ticket.getT_punishment_warning(),ticket.getT_punishment_fine(),ticket.getT_punishment_deduction(),ticket.getT_verification(),ticket.getD_no(),ticket.getC_no(),ticket.getP_no());
    }

    @Override
    public void deleteById(Connection conn, long T_no) {
        String sql = "delete from ticket where T_no = ?";
        updateResources(conn,sql,T_no);
    }

    @Override
    public void update(Connection conn, Ticket ticket) {
        String sql = "update ticket set T_date = ?,T_time = ?,T_location = ?,T_record = ?,T_punishment_warning = ?,T_punishment_fine = ?,T_punishment_deduction = ?,T_verification = ?,D_no = ?,C_no = ?,P_no = ? " +
                "where T_no = ?";
        updateResources(conn,sql,ticket.getT_date(),ticket.getT_time(),ticket.getT_location(),ticket.getT_record(),ticket.getT_punishment_warning(),ticket.getT_punishment_fine(),ticket.getT_punishment_deduction(),ticket.getT_verification(),ticket.getD_no(),ticket.getC_no(),ticket.getP_no(),ticket.getT_no());
    }

    @Override
    public Ticket getTicketById(Connection conn, long T_no) {
        String sql = "select * " +
                "from ticket " +
                "where T_no=?";
        Ticket ticket = queryOnceForAll(conn, Ticket.class, sql, T_no);
        return ticket;
    }

    @Override
    public List<Ticket> getAllTicketsByDriverId(Connection conn, long D_no) {
        String sql = "select T_no,T_date,T_time,T_location,T_record,T_punishment_warning,T_punishment_fine,T_punishment_deduction,T_verification,D_no,C_no,P_no " +
                "from ticket " +
                "where D_no=?";
        List<Ticket> list = queryForAll(conn, Ticket.class, sql,D_no);
        return list;
    }

    @Override
    public List<Ticket> getAllTicketsByPolicemenId(Connection conn, long P_numbering) {
        String sql = "select T_no,T_date,T_time,T_location,T_record,T_punishment_warning,T_punishment_fine,T_punishment_deduction,T_verification,D_no,C_no,P_no " +
                "from ticket " +
                "where P_numbering = ?";
        List<Ticket> list = queryForAll(conn, Ticket.class, sql,P_numbering);
        return list;
    }

    @Override
    public Long getCount(Connection conn,long P_no) {
        String sql = "select count(*) from ticket where P_no = ?";
        return getValue(conn,sql,P_no);
    }

}
