package com.liu.service;

import com.liu.dto.Driver;
import com.liu.dto.Ticket;
import com.liu.dto.ViewTicket;

/**
 * @Author: LiuYi
 * @Date: 2021/7/5 11:00
 */
public interface TicketService {

    /**
     * 添加罚单
     * @param ticket
     */
    void insert(Ticket ticket);

    /**
     * 修改罚单的信息
     * @param ticket
     */
    void update(Ticket ticket);

    /**
     * 删除罚单
     * @param T_no
     */
    void delete(long T_no);

    /**
     * 根据 罚单ID 查询对应罚单
     * @param T_no
     * @return
     */
    Ticket select(long T_no);

}
