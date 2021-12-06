package com.liu.dao;

import com.liu.dto.Policemen;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 此接口用于规范针对于 Policemen 表的常用操作
 * @Author: LiuYi
 * @Date: 2021/7/4 22:20
 */
public interface PolicemenDao {

    /**
     * 得到登陆的警察
     * @param conn
     * @param P_name
     * @return
     */
    Policemen getLoginUser(Connection conn, String P_name);

    /**
     * 将 Policemen 对象存放入数据库中
     * @param conn
     * @param policemen
     */
    void insert(Connection conn, Policemen policemen);

    /**
     * 针对指定的编号，删除表中的一条记录
     * @param conn
     * @param P_numbering
     */
    void deleteById(Connection conn,long P_numbering);

    /**
     * 针对 Policemen 对象，修改数据库中相应的记录
     * @param conn
     * @param policemen
     */
    void update(Connection conn,Policemen policemen);

    /**
     * 根据指定的编号得到对应的 Policemen 对象
     * @param conn
     * @param P_numbering
     * @return
     */
    Policemen getPolicemenByNumber(Connection conn,long P_numbering);

    /**
     * 根据指定的No得到对应的 Policemen 对象
     * @param conn
     * @param P_no
     * @return
     */
    Policemen getPolicemenByNo(Connection conn,long P_no);

    /**
     * 获取到数据库中所有的 Policemen 的记录
     * @param conn
     * @return
     */
    List<Policemen> getAllPolicemen(Connection conn);

    /**
     * 返回数据表中数据的条目数
     * @param conn
     * @return
     */
    Long getCount(Connection conn);

    /**
     * 得到数据表中生日最大的条目
     * @param conn
     * @return
     */
    LocalDateTime getMaxBirth(Connection conn);
}
