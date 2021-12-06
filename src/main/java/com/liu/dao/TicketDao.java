package com.liu.dao;

import com.liu.dto.Ticket;
import com.liu.dto.ViewTicket;

import java.sql.Connection;
import java.util.List;

/**
 * 此接口用于规范针对于 Ticket 表的常用操作
 * @Author: LiuYi
 * @Date: 2021/7/4 22:21
 */
public interface TicketDao {

    /**
     * 将 Ticket 对象存放入数据库中
     * @param conn
     * @param ticket
     */
    void insert(Connection conn, Ticket ticket);

    /**
     * 针对指定的ID，删除表中的一条记录
     * @param conn
     * @param T_no
     */
    void deleteById(Connection conn,long T_no);

    /**
     * 针对 Ticket 对象，修改数据库中相应的记录
     * @param conn
     * @param ticket
     */
    void update(Connection conn, Ticket ticket);

    /**
     * 根据指定的ID得到对应的 Ticket 对象
     * @param conn
     * @param T_no
     * @return
     */
    Ticket getTicketById(Connection conn,long T_no);

    /**
     * 通过驾驶人 ID 获取到数据库中所有的 Ticket 的记录
     * @param conn
     * @param D_no
     * @return
     */
    List<Ticket> getAllTicketsByDriverId(Connection conn,long D_no);

    /**
     * 通过交警 编号 获取到数据库中所有的 Ticket 的记录
     * @param conn
     * @param P_numbering
     * @return
     */
    List<Ticket> getAllTicketsByPolicemenId(Connection conn,long P_numbering);

    /**
     * 通过警察 ID 返回数据表中数据的条目数
     * @param conn
     * @param P_no
     * @return
     */
    Long getCount(Connection conn,long P_no);

}
