package com.liu.util;

import com.liu.dto.Driver;
import com.liu.dto.Policemen;

import java.lang.reflect.Field;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

/**
 * 封装了对数据表的常用操作
 * @Author: LiuYi
 * @Date: 2021/7/4 20:39
 */
public abstract class BaseDao {

    /**
     * 通用的增删改操作
     * @param sql 要执行的sql语句
     * @param args sql语句中的参数
     */
    public static void updateResources(Connection conn,String sql,Object...args) {
        PreparedStatement ps = null;
        try {
            // 1.预编译SQL返回 PreparedStatement 的实例
            ps = conn.prepareStatement(sql);
            // 2.填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            // 3.执行
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResourse(ps);
        }
    }

    /**
     * 针对不同表，通用的获取一个对象的方法
     * @param conn Connection连接
     * @param clazz 返回的实体类型
     * @param sql 要执行的sql语句
     * @param args sql语句中的参数
     * @param <T> 泛型
     * @return 返回指定的实体类型
     */
    public static <T> T queryOnceForAll(Connection conn,Class<T> clazz,String sql,Object...args) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // 1.预编译SQL返回 PreparedStatement 的实例
            ps = conn.prepareStatement(sql);
            // 2.填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }

            // 3.执行
            rs = ps.executeQuery();

            // 4.获取结果集的元数据：ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();
            // 5.通过 ResultSetMetaData 获取结果集中的列数
            int columnCount = rsmd.getColumnCount();
            if (rs.next()) {
                T t = clazz.newInstance();
                // 处理结果集中一行数据中的每一列
                for (int i = 0; i < columnCount; i++) {
                    // 获取列值
                    Object columnValue = rs.getObject(i + 1);
                    // 获取每个列的列名
                    String columnName = rsmd.getColumnName(i + 1);
                    // 给 t 对象指定的columnName属性，赋值为columnValue，通过反射
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t,columnValue);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResourse(null,ps,rs);
        }
        return null;
    }

    /**
     * 对所有表的任意查询操作
     * @param conn Connection连接
     * @param clazz 返回的实体类型
     * @param sql 要执行的sql语句
     * @param args sql语句中的参数
     * @param <T> 泛型
     * @return 返回指定的实体类型的集合
     */
    public static <T> List<T> queryForAll(Connection conn,Class<T> clazz, String sql, Object...args) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // 1.预编译SQL返回 PreparedStatement 的实例
            ps = conn.prepareStatement(sql);
            // 2.填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            // 3.执行
            rs = ps.executeQuery();

            // 4.获取结果集的元数据：ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();
            // 5.通过 ResultSetMetaData 获取结果集中的列数
            int columnCount = rsmd.getColumnCount();
            ArrayList<T> list = new ArrayList<>();
            while(rs.next()) {
                T t = clazz.newInstance();
                // 处理结果集中一行数据中的每一列:给t对象赋值的过程
                for (int i = 0; i < columnCount; i++) {
                    // 获取列值
                    Object columnValue = rs.getObject(i + 1);

                    // 获取每个列的列名
                    String columnName = rsmd.getColumnName(i + 1);

                    // 给 t 对象指定的columnName属性，赋值为columnValue，通过反射
                    Field field = Driver.class.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t,columnValue);
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResourse(conn,ps,rs);
        }
        return null;
    }

    /**
     * 用于一些特殊查询，如：集合查询
     * @param conn Connection连接
     * @param sql 要执行的sql语句
     * @param args sql语句中的参数
     * @param <E> 泛型
     * @return
     */
    public static <E> E getValue(Connection conn,String sql,Object...args) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }

            rs = ps.executeQuery();
            if (rs.next()) {
                return (E) rs.getObject(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResourse(null,ps,rs);
        }
        return null;
    }
}
