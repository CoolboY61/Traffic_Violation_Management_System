package com.liu.service;


import com.liu.dto.Policemen;

/**
 * @Author: LiuYi
 * @Date: 2021/7/5 11:00
 */
public interface PolicemenService {
    /**
     * 警察登录
     * @param P_name
     * @return
     */
    Policemen login(String P_name);

    /**
     * 添加警察
     * @param policemen
     */
    void insert(Policemen policemen);

    /**
     * 警察修改自己的信息
     * @param policemen
     */
    void update(Policemen policemen);

    /**
     * 删除警察
     * @param P_no
     */
    void delete(long P_no);

    /**
     * 根据警察的编号查询对应警察信息
     * @param P_numbering
     * @return
     */
    Policemen select(long P_numbering);

    /**
     * 根据警察的ID查询对应警察信息
     * @param P_no
     * @return
     */
    Policemen selectByNo(long P_no);
}
