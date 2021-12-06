package com.liu.service.impl;

import com.liu.dao.DriverDao;
import com.liu.dao.impl.DriverDaoImpl;
import com.liu.dto.Driver;
import com.liu.dto.Policemen;
import com.liu.service.DriverService;
import com.liu.service.PolicemenService;
import com.liu.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * @Author: LiuYi
 * @Date: 2021/7/4 23:59
 */
public class DriverServiceImpl implements DriverService {

    /**
     * 业务都会调用dao层，所有我们要引入dao层
      */
    private DriverDao driverDao;
    public DriverServiceImpl() {
        driverDao = new DriverDaoImpl();
    }

    /**
     * 用户登录业务，调用 DriverDao 的getLoginUser,
     * 根据信息获取到相关 Driver 提交给 controller
     * @param D_name
     * @return
     */
    @Override
    public Driver login(String D_name) {
        Connection conn = null;
        Driver driver = new Driver();
        try {
            conn = JDBCUtils.getConnection();
            driver = driverDao.getLoginUser(conn,D_name);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResourse(conn);
        }
        return driver;
    }

    /**
     * 添加用户业务，调用 DriverDao 的 insert
     * 将提供的用户添加入数据库中
     * @param driver
     */
    @Override
    public void insert(Driver driver) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            driverDao.insert(conn,driver);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResourse(conn);
        }
    }

    /**
     * 修改用户信息业务，调用 DriverDao 的 update
     * 对比提供的用户数据进行修改
     * @param driver
     */
    @Override
    public void update(Driver driver) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            driverDao.update(conn,driver);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResourse(conn);
        }
    }

    /**
     * 删除用户业务，调用 DriverDao 的 delete
     * 对比提供的用户ID进行删除
     * @param D_no
     */
    @Override
    public void delete(long D_no) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();

            driverDao.deleteById(conn,D_no);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResourse(conn);
        }
    }

    /**
     * 获取用户信息业务，调用 DriverDao 的 getDriverById
     * 根据提供的 用户ID 返回对应用户
     * @param D_no
     * @return
     */
    @Override
    public Driver select(long D_no) {
        Connection conn = null;
        Driver driver = null;
        try {
            conn = JDBCUtils.getConnection();
            driver = driverDao.getDriverById(conn,D_no);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResourse(conn);
        }
        return driver;
    }


    @Test
    public void testInsert() throws ParseException {
//        LocalDate localDate = LocalDate.of(2000,2,3);
//        LocalTime localTime = LocalTime.of(00, 00, 00);
//        LocalDateTime localDateTime = LocalDateTime.of(localDate,localTime);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2002-08-04");
        Driver driver = new Driver("陈翔","男",new Date(date.getTime()),"15669477236","126547225569",710000,"甘肃省 兰州市 里吧县");
        new DriverServiceImpl().insert(driver);
    }
    @Test
    public void testUpdate() throws ParseException {
//        LocalDate localDate = LocalDate.of(2001,7,5);
//        LocalTime localTime = LocalTime.of(00, 00, 00);
//        LocalDateTime localDateTime = LocalDateTime.of(localDate,localTime);\
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2002-08-04");
        Driver driver = new Driver("陈翔","男",new Date(date.getTime()),"15669477236","126547225569",710000,"山东省 菏泽市 曹县");
        new DriverServiceImpl().update(driver);
    }
    @Test
    public void testDelete() {
        long ID = 5;
        new DriverServiceImpl().delete(ID);
    }
    @Test
    public void testLogin() {
        DriverService driverService = new DriverServiceImpl();
        Driver driver = driverService.login("刘艺");
        System.out.println(driver);
    }
    @Test
    public void testSelect() {
        DriverService driverService = new DriverServiceImpl();
        Driver driver = driverService.select(1);
        System.out.println(driver);
    }
}
