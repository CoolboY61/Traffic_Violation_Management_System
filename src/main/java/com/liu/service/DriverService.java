package com.liu.service;

import com.liu.dto.Driver;

/**
 * @Author: LiuYi
 * @Date: 2021/7/4 23:57
 */
public interface DriverService {
    /**
     * 用户登录
     * @param D_name
     * @return
     */
    Driver login(String D_name);

    /**
     * 添加用户
     * @param driver
     */
    void insert(Driver driver);

    /**
     * 用户修改自己的信息
     * @param driver
     */
    void update(Driver driver);

    /**
     * 删除用户
     * @param D_no
     */
    void delete(long D_no);

    /**
     * 根据用户的ID查询对应用户信息
     * @param D_no
     * @return
     */
    Driver select(long D_no);
}
