package com.liu.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.liu.dto.Driver;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.Properties;

/**
 *
 * @Author: LiuYi
 * @Date: 2021/7/4 16:55
 */
public abstract class JDBCUtils {
//    /**
//     * 获取数据库连接
//     * @return 返回获取的连接
//     */
//    public static Connection getConnection() throws Exception {
//        // 1.读取配置文件中的4个基本信息
//        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
//
//        Properties pros = new Properties();
//        pros.load(is);
//        String user = pros.getProperty("user");
//        String password = pros.getProperty("password");
//        String url = pros.getProperty("url");
//        String driver = pros.getProperty("driverClass");
//
//        // 2.加载驱动
//        Class.forName(driver);
//
//        // 3.获取连接
//        Connection conn = DriverManager.getConnection(url, user, password);
//        return conn;
//    }

    /**
     * 使用Druid数据库连接池技术
     */
    private static DataSource source;
    static {
        try {
            Properties pros = new Properties();
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pros.load(is);
            source = DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据路连接
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {
        Connection conn = source.getConnection();
        return conn;
    }

//    /**
//     * 获取连接池对象
//     */
//    public static DataSource getDataSource(){
//        return source;
//    }

    /**
     * 关闭连接
     * @param conn Connection连接
     */
    public static void closeResourse(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 关闭连接
     * @param ps PreparedStatement连接
     */
    public static void closeResourse(Statement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭连接
     * @param conn Connection连接
     * @param ps PreparedStatement连接
     */
    public static void closeResourse(Connection conn, Statement ps) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭连接
     * @param conn Connection连接
     * @param ps PreparedStatement连接
     * @param rs ResultSet连接
     */
    public static void closeResourse(Connection conn, Statement ps,ResultSet rs) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testQuery() throws Exception {
        String sql = "SELECT D_no,D_name,D_sex,D_birthday,D_phone,D_license_number,D_postcode,D_address FROM driver WHERE D_no = ?";
        Connection conn = getConnection();
        Driver driver1 = BaseDao.queryOnceForAll(conn,Driver.class,sql,1);
        System.out.println(driver1);

        sql = "SELECT D_no,D_name,D_sex,D_birthday,D_phone,D_license_number,D_postcode,D_address FROM driver WHERE D_sex = ?";
        List<Driver> list = BaseDao.queryForAll(conn,Driver.class, sql, "男");
        list.forEach(System.out::println);
    }
}
