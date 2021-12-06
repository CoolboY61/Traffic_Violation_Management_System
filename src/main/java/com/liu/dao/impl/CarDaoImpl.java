package com.liu.dao.impl;

import com.liu.util.BaseDao;
import com.liu.dao.CarDao;
import com.liu.dto.Car;

import java.sql.Connection;
import java.util.List;

/**
 * @Author: LiuYi
 * @Date: 2021/7/4 22:37
 */
public class CarDaoImpl extends BaseDao implements CarDao {
    @Override
    public void insert(Connection conn, Car car) {
        String sql = "insert into car(C_number,C_model,C_manufacturer,C_production_date,D_no) " +
                "values(?,?,?,?,?)";
        updateResources(conn,sql,car.getC_number(),car.getC_model(),car.getC_manufacturer(),car.getC_production_date(),car.getD_no());
    }

    @Override
    public void deleteById(Connection conn, long C_no) {
        String sql = "delete from Car where C_no = ?";
        updateResources(conn,sql,C_no);
    }

    @Override
    public void update(Connection conn, Car car) {
        String sql = "update car set C_model = ?,C_manufacturer = ?,C_production_date = ?,D_no = ? where C_number = ?";
        updateResources(conn,sql,car.getC_model(),car.getC_manufacturer(),car.getC_production_date(),car.getD_no(),car.getC_number());
    }

    @Override
    public Car getCarById(Connection conn, long C_no) {
        String sql = "select C_no,C_number,C_model,C_manufacturer,C_production_date,D_no " +
                "from car " +
                "where C_no = ?";
        Car car = queryOnceForAll(conn,Car.class,sql,C_no);
        return car;
    }

    @Override
    public List<Car> getAllCars(Connection conn, long D_no) {
        String sql = "select C_no,C_number,C_model,C_manufacturer,C_production_date,D_no " +
                "from car " +
                "where D_no = ?";
        List<Car> list = queryForAll(conn, Car.class, sql,D_no);
        return list;
    }

    @Override
    public Long getCount(Connection conn) {
        String sql = "select count(*) from car";
        return getValue(conn,sql);
    }
}
