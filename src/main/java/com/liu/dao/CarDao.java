package com.liu.dao;

import com.liu.dto.Car;

import java.sql.Connection;
import java.util.List;

/**
 * 此接口用于规范针对于 Car 表的常用操作
 * @Author: LiuYi
 * @Date: 2021/7/4 22:20
 */
public interface CarDao {
    /**
     * 将 car 对象存放入数据库中
     * @param conn
     * @param car
     */
    void insert(Connection conn,Car car);

    /**
     * 针对指定的ID，删除表中的一条记录
     * @param conn
     * @param C_no
     */
    void deleteById(Connection conn,long C_no);

    /**
     * 针对 Car 对象，修改数据库中相应的记录
     * @param conn
     * @param car
     */
    void update(Connection conn,Car car);

    /**
     * 根据指定的ID得到对应的 Car 对象
     * @param conn
     * @param C_no
     * @return
     */
    Car getCarById(Connection conn,long C_no);

    /**
     * 根据驾驶人 ID 获取到数据库中所有的 Car 的记录
     * @param conn
     * @param D_no
     * @return
     */
    List<Car> getAllCars(Connection conn,long D_no);

    /**
     * 返回数据表中数据的条目数
     * @param conn
     * @return
     */
    Long getCount(Connection conn);

}
