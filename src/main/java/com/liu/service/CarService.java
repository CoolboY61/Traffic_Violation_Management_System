package com.liu.service;

import com.liu.dto.Car;
import com.liu.dto.Driver;

/**
 * @Author: LiuYi
 * @Date: 2021/7/5 10:59
 */
public interface CarService {

    /**
     * 添加车辆
     * @param car
     */
    void insert(Car car);

    /**
     * 修改车辆的信息
     * @param car
     */
    void update(Car car);

    /**
     * 删除车辆
     * @param C_no
     */
    void delete(long C_no);

    /**
     * 根据车辆的ID查询对应车辆信息
     * @param C_no
     * @return
     */
    Car select(long C_no);
}
