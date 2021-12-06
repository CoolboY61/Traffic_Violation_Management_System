package com.liu.service.impl;

import com.liu.dao.TicketDao;
import com.liu.dao.impl.TicketDaoImpl;
import com.liu.dto.Driver;
import com.liu.dto.Ticket;
import com.liu.dto.ViewTicket;
import com.liu.service.TicketService;
import com.liu.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @Author: LiuYi
 * @Date: 2021/7/5 21:13
 */
public class TicketServiceImpl implements TicketService {

    /**
     * 业务都会调用dao层，所有我们要引入dao层
     */
    private TicketDao ticketDao;
    public TicketServiceImpl() {
        ticketDao = new TicketDaoImpl();
    }

    /**
     * 添加罚单业务，调用 TicketDao 的 insert
     * 将提供的罚单添加入数据库中
     * @param ticket
     */
    @Override
    public void insert(Ticket ticket) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            ticketDao.insert(conn,ticket);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResourse(conn);
        }
    }
    /**
     * 修改罚单信息业务，调用 TicketDao 的 update
     * 对比提供的罚单数据进行修改
     * @param ticket
     */
    @Override
    public void update(Ticket ticket) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            ticketDao.update(conn,ticket);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResourse(conn);
        }
    }
    /**
     * 删除罚单业务，调用 TicketDao 的 delete
     * 对比提供的罚单ID进行删除
     * @param T_no
     */
    @Override
    public void delete(long T_no) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            ticketDao.deleteById(conn,T_no);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResourse(conn);
        }
    }
    /**
     * 获取罚单业务，调用 TicketDao 的 getTicketById
     * 根据提供的 罚单ID 返回对应罚单
     * @param T_no
     * @return
     */
    @Override
    public Ticket select(long T_no) {
        Connection conn = null;
        Ticket ticket = null;
        try {
            conn = JDBCUtils.getConnection();
            ticket = ticketDao.getTicketById(conn,T_no);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResourse(conn);
        }
        return ticket;
    }

    //    @Test
//    public void testInsert() {
//        LocalDate localDate1 = LocalDate.of(2021,7,5);
//        LocalTime localTime1 = LocalTime.of(11, 35, 0);
//        LocalDateTime localDateTime1 = LocalDateTime.of(localDate1,localTime1);
//        LocalDate localDate2 = LocalDate.of(2021,7,5);
//        LocalTime localTime2 = LocalTime.of(11, 37, 0);
//        LocalDateTime localDateTime2 = LocalDateTime.of(localDate2,localTime2);
//        Ticket ticket = new Ticket(85475, localDateTime1, localDateTime2, "西安市 未央区 张家宝街道", "闯红灯", 1, 1, 0, 1, 2, 3, 1);
//        new TicketServiceImpl().insert(ticket);
//    }
//    @Test
//    public void testUpdate() {
//        LocalDate localDate1 = LocalDate.of(2021,6,5);
//        LocalTime localTime1 = LocalTime.of(14, 30, 0);
//        LocalDateTime localDateTime1 = LocalDateTime.of(localDate1,localTime1);
//        LocalDate localDate2 = LocalDate.of(2021,6,5);
//        LocalTime localTime2 = LocalTime.of(15, 4, 0);
//        LocalDateTime localDateTime2 = LocalDateTime.of(localDate2,localTime2);
//        Ticket ticket = new Ticket(54286,localDateTime1, localDateTime2, "西安市 高新区 大通巷", "追尾", 0, 1, 1, 1, 3, 4, 2);
//        new TicketServiceImpl().update(ticket);
//    }
    @Test
    public void testDelete() {
        long T_no = 85475;
        new TicketServiceImpl().delete(T_no);
    }

    @Test
    public void testSelect() {
        TicketService ticketService = new TicketServiceImpl();
        Ticket ticket = ticketService.select(54286);
        System.out.println(ticket);
    }
}
