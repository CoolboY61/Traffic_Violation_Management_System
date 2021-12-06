package com.liu.dao.impl;

import com.liu.dto.Driver;
import com.liu.util.BaseDao;
import com.liu.dao.PolicemenDao;
import com.liu.dto.Policemen;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author: LiuYi
 * @Date: 2021/7/4 22:38
 */
public class PolicemenDaoImpl extends BaseDao implements PolicemenDao {

    @Override
    public Policemen getLoginUser(Connection conn, String P_name) {
        String sql = "select P_no,P_name,P_sex,P_birthday,P_phone,P_numbering " +
                "from policemen " +
                "where P_name = ?";
        Policemen policemen = queryOnceForAll(conn,Policemen.class,sql,P_name);
        return policemen;
    }

    @Override
    public void insert(Connection conn, Policemen policemen) {
        String sql = "insert into policemen(P_name,P_sex,P_birthday,P_phone,P_numbering) " +
                "values(?,?,?,?,?)";
        updateResources(conn,sql,policemen.getP_name(),policemen.getP_sex(),policemen.getP_birthday(),policemen.getP_phone(),policemen.getP_numbering());
    }

    @Override
    public void deleteById(Connection conn, long P_numbering) {
        String sql = "delete from policemen where P_numbering = ?";
        updateResources(conn,sql,P_numbering);
    }

    @Override
    public void update(Connection conn, Policemen policemen) {
        String sql = "update policemen set P_sex = ?,P_birthday = ?,P_phone = ?,P_numbering = ? where P_name = ?";
        updateResources(conn,sql,policemen.getP_sex(),policemen.getP_birthday(),policemen.getP_phone(),policemen.getP_numbering(),policemen.getP_name());
    }

    @Override
    public Policemen getPolicemenByNumber(Connection conn, long P_numbering) {
        String sql = "select P_no,P_name,P_sex,P_birthday,P_phone,P_numbering " +
                "from policemen " +
                "where P_numbering = ?";
        Policemen policemen = queryOnceForAll(conn, Policemen.class, sql, P_numbering);
        return policemen;
    }

    @Override
    public Policemen getPolicemenByNo(Connection conn, long P_no) {
        String sql = "select P_no,P_name,P_sex,P_birthday,P_phone,P_numbering " +
                "from policemen " +
                "where P_no = ?";
        Policemen policemen = queryOnceForAll(conn, Policemen.class, sql, P_no);
        return policemen;
    }

    @Override
    public List<Policemen> getAllPolicemen(Connection conn) {
        String sql = "select P_no,P_name,P_sex,P_birthday,P_phone,P_numbering " +
                "from policemen";
        List<Policemen> list = queryForAll(conn, Policemen.class, sql);
        return list;
    }

    @Override
    public Long getCount(Connection conn) {
        String sql = "select count(*) from policemen";
        return getValue(conn,sql);
    }

    @Override
    public LocalDateTime getMaxBirth(Connection conn) {
        String sql = "select min(D_birthday) from policemen";
        return getValue(conn,sql);
    }
}
