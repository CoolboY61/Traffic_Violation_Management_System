package com.liu.dao;

import com.liu.dto.Driver;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 此接口用于规范针对于 Driver 表的常用操作
 * @Author: LiuYi
 * @Date: 2021/7/4 21:05
 */
public interface DriverDao {

    /**
     * 得到登陆的用户
     * @param D_name
     */
    Driver getLoginUser(Connection conn,String D_name);

    /**
     * 将 driver 对象存放入数据库中
     * @param driver
     */
    void insert(Connection conn,Driver driver);

    /**
     * 针对指定的ID，删除表中的一条记录
     * @param D_no
     */
    void deleteById(Connection conn,long D_no);

    /**
     * 针对 driver 对象的姓名，修改数据库中相应的记录
     * @param driver
     */
    void update(Connection conn,Driver driver);

    /**
     * 根据指定的ID得到对应的Driver对象
     * @param D_no
     * @return
     */
    Driver getDriverById(Connection conn,long D_no);

    /**
     * 获取到数据库中所有的Driver的记录
     * @return
     */
    List<Driver> getAllDrivers(Connection conn);

    /**
     * 返回数据表中数据的条目数
     * @return
     */
    Long getCount(Connection conn);

    /**
     * 得到数据表中生日最大的条目
     * @return
     */
    LocalDateTime getMaxBirth(Connection conn);
}
