package com.liu.service.impl;

import com.liu.dao.PolicemenDao;
import com.liu.dao.impl.PolicemenDaoImpl;
import com.liu.dto.Driver;
import com.liu.dto.Policemen;
import com.liu.service.DriverService;
import com.liu.service.PolicemenService;
import com.liu.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @Author: LiuYi
 * @Date: 2021/7/5 20:46
 */
public class PolicemenServiceImpl implements PolicemenService {

    /**
     * 业务都会调用dao层，所有我们要引入dao层
     */
    private PolicemenDao policemenDao;
    public PolicemenServiceImpl() {
        policemenDao = new PolicemenDaoImpl();
    }

    /**
     * 警察登录业务，调用 PolicemenDao 的getLoginUser,
     * 根据信息获取到相关 Policemen 提交给 controller
     * @param P_name
     * @return
     */
    @Override
    public Policemen login(String P_name) {
        Connection conn = null;
        Policemen policemen = null;
        try {
            conn = JDBCUtils.getConnection();
            policemen = policemenDao.getLoginUser(conn,P_name);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResourse(conn);
        }
        return policemen;
    }

    /**
     * 添加警察业务，调用 PolicemenDao 的 insert
     * 将提供的警察添加入数据库中
     * @param policemen
     */
    @Override
    public void insert(Policemen policemen) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            policemenDao.insert(conn,policemen);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResourse(conn);
        }
    }

    /**
     * 修改警察信息业务，调用 PolicemenDao 的 update
     * 对比提供的警察数据进行修改
     * @param policemen
     */
    @Override
    public void update(Policemen policemen) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            policemenDao.update(conn,policemen);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResourse(conn);
        }
    }

    /**
     * 删除警察业务，调用 PolicemenDao 的 delete
     * 对比提供的警察ID进行删除
     * @param P_no
     */
    @Override
    public void delete(long P_no) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();

            policemenDao.deleteById(conn,P_no);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResourse(conn);
        }
    }

    /**
     * 获取警察信息业务，调用 PolicemenDao 的 getPolicemenByNumber
     * 根据提供的 警员编号 返回对应警员
     * @param P_numbering
     * @return
     */
    @Override
    public Policemen select(long P_numbering) {
        Connection conn = null;
        Policemen policemen = null;
        try {
            conn = JDBCUtils.getConnection();
            policemen = policemenDao.getPolicemenByNumber(conn,P_numbering);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResourse(conn);
        }
        return policemen;
    }

    @Override
    public Policemen selectByNo(long P_no) {
        Connection conn = null;
        Policemen policemen = null;
        try {
            conn = JDBCUtils.getConnection();
            policemen = policemenDao.getPolicemenByNo(conn,P_no);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResourse(conn);
        }
        return policemen;
    }


    //    @Test
//    public void testInsert() {
//        LocalDate localDate = LocalDate.of(1995,5,6);
//        LocalTime localTime = LocalTime.of(00, 00, 00);
//        LocalDateTime localDateTime = LocalDateTime.of(localDate,localTime);
//        Policemen policemen = new Policemen(58200,"杨裕兴","男",localDateTime,"18775548962",19855);
//        new PolicemenServiceImpl().insert(policemen);
//    }
//    @Test
//    public void testUpdate() {
//        LocalDate localDate = LocalDate.of(1997,2,4);
//        LocalTime localTime = LocalTime.of(00, 00, 00);
//        LocalDateTime localDateTime = LocalDateTime.of(localDate,localTime);
//        Policemen policemen = new Policemen(65123,"刘芳宇","女",localDateTime,"14752268524",17565);
//        new PolicemenServiceImpl().update(policemen);
//    }
//    @Test
//    public void testDelete() {
//        int P_numbering = 5;
//        new PolicemenServiceImpl().delete(17565);
//    }
    @Test
    public void testLogin() {
        PolicemenService policemenService = new PolicemenServiceImpl();
        Policemen policemen = policemenService.login("刘芳宇");
        System.out.println(policemen);
    }
    @Test
    public void testSelect() {
        PolicemenService policemenService = new PolicemenServiceImpl();
        Policemen policemen = policemenService.select(17565);
        System.out.println(policemen);
    }
}
