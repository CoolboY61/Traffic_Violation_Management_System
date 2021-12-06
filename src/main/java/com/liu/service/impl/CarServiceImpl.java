package com.liu.service.impl;

import com.liu.dao.CarDao;
import com.liu.dao.DriverDao;
import com.liu.dao.impl.CarDaoImpl;
import com.liu.dao.impl.DriverDaoImpl;
import com.liu.dto.Car;
import com.liu.dto.Driver;
import com.liu.service.CarService;
import com.liu.service.DriverService;
import com.liu.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @Author: LiuYi
 * @Date: 2021/7/5 18:02
 */
public class CarServiceImpl implements CarService {

    /**
     * 业务都会调用dao层，所有我们要引入dao层
     */
    private CarDao carDao;
    public CarServiceImpl() {
        carDao = new CarDaoImpl();
    }

    /**
     * 添加车辆业务，调用 CarDao 的 insert
     * 将提供的车辆添加入数据库中
     * @param car
     */
    @Override
    public void insert(Car car) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();

            carDao.insert(conn,car);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResourse(conn);
        }
    }

    /**
     * 修改车辆信息业务，调用 CarDao 的 update
     * 对比提供的用户数据进行修改
     * @param car
     */
    @Override
    public void update(Car car) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            carDao.update(conn,car);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResourse(conn);
        }
    }

    /**
     * 删除汽车业务，调用 CarDao 的 delete
     * 对比提供的车辆ID进行删除
     * @param C_no
     */
    @Override
    public void delete(long C_no) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();

            carDao.deleteById(conn,C_no);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResourse(conn);
        }
    }

    /**
     * 获取车辆信息业务，调用 CarDao 的 getCarById
     * 根据提供的 车辆ID 返回对应车辆
     * @param C_no
     * @return
     */
    @Override
    public Car select(long C_no) {
        Connection conn = null;
        Car car = null;
        try {
            conn = JDBCUtils.getConnection();
            car = carDao.getCarById(conn,C_no);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResourse(conn);
        }
        return car;
    }


//    @Test
//    public void testInsert() {
//        LocalDate localDate = LocalDate.of(2020,10,2);
//        LocalTime localTime = LocalTime.of(00, 00, 00);
//        LocalDateTime localDateTime = LocalDateTime.of(localDate,localTime);
//        Car car = new Car("M1S4G1", "D9I6", "MSLD", localDateTime, 6);
//        new CarServiceImpl().insert(car);
//    }
//    @Test
//    public void testUpdate() {
//        LocalDate localDate = LocalDate.of(2003,2,4);
//        LocalTime localTime = LocalTime.of(00, 00, 00);
//        LocalDateTime localDateTime = LocalDateTime.of(localDate,localTime);
//        Car car = new Car("F5I6C8", "I5A8", "LBJN", localDateTime, 4);
//        new CarServiceImpl().update(car);
//    }
    @Test
    public void testDelete() {
        int C_no = 5;
        new CarServiceImpl().delete(C_no);
    }
    @Test
    public void testSelect() {
        CarService carService = new CarServiceImpl();
        Car car = carService.select(1);
        System.out.println(car);
    }
}
