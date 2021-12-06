package com.liu.dao.impl;

import com.liu.dto.Car;
import com.liu.dto.Policemen;
import com.liu.util.BaseDao;
import com.liu.dao.DriverDao;
import com.liu.dto.Driver;
import com.liu.util.JDBCUtils;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author: LiuYi
 * @Date: 2021/7/4 21:28
 */
public class DriverDaoImpl extends BaseDao implements DriverDao {


    @Override
    public Driver getLoginUser(Connection conn,String D_name) {
        String sql = "select D_no,D_name,D_sex,D_birthday,D_phone,D_license_number,D_postcode,D_address " +
                "from driver " +
                "where D_name = ?";

        return queryOnceForAll(conn,Driver.class,sql,D_name);
    }

    @Override
    public void insert(Connection conn,Driver driver) {
        String sql = "insert into driver(D_name,D_sex,D_birthday,D_phone,D_license_number,D_postcode,D_address) " +
                    "values(?,?,?,?,?,?,?)";
        updateResources(conn,sql,driver.getD_name(),driver.getD_sex(),driver.getD_birthday(),driver.getD_phone(),driver.getD_license_number(),driver.getD_postcode(),driver.getD_address());
    }

    @Override
    public void deleteById(Connection conn,long D_no) {
        String sql = "delete from driver where D_no = ?";
        updateResources(conn,sql,D_no);
    }

    @Override
    public void update(Connection conn,Driver driver) {
        String sql = "update driver set D_sex = ?,D_birthday = ?,D_phone = ?,D_license_number = ?,D_postcode = ?,D_address = ? where D_name = ?";
        updateResources(conn,sql,driver.getD_sex(),driver.getD_birthday(),driver.getD_phone(),driver.getD_license_number(),driver.getD_postcode(),driver.getD_address(),driver.getD_name());
    }

    @Override
    public Driver getDriverById(Connection conn,long D_no) {
        String sql = "select D_no,D_name,D_sex,D_birthday,D_phone,D_license_number,D_postcode,D_address " +
                "from driver " +
                "where D_no = ?";
        return queryOnceForAll(conn,Driver.class,sql,D_no);
    }

    @Override
    public List<Driver> getAllDrivers(Connection conn) {
        String sql = "select D_no,D_name,D_sex,D_birthday,D_phone,D_license_number,D_postcode,D_address " +
                "from driver";
        return queryForAll(conn, Driver.class, sql);
    }

    @Override
    public Long getCount(Connection conn) {
        String sql = "select count(*) from driver";
        return getValue(conn,sql);
    }

    @Override
    public LocalDateTime getMaxBirth(Connection conn) {
        String sql = "select min(D_birthday) from driver";
        return getValue(conn,sql);
    }

}
