package com.liu.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @Author: LiuYi
 * @Date: 2021/7/3 18:53
 * 警察实体类
 */
public class Policemen implements Serializable {
    /**
     * 警察ID编号
     */
    private long P_no;

    /**
     * 姓名
     */
    private String P_name;

    /**
     * 性别
     */
    private String P_sex;

    /**
     * 出生日期
     */
    private Date P_birthday;

    /**
     * 电话
     */
    private String P_phone;

    /**
     * 编号
     */
    private long P_numbering;

    public Policemen() {
    }

    public Policemen(String p_name, String p_sex, Date p_birthday, String p_phone, long p_numbering) {
        P_name = p_name;
        P_sex = p_sex;
        P_birthday = p_birthday;
        P_phone = p_phone;
        P_numbering = p_numbering;
    }

    public Policemen(long p_no, String p_name, String p_sex, Date p_birthday, String p_phone, long p_numbering) {
        P_no = p_no;
        P_name = p_name;
        P_sex = p_sex;
        P_birthday = p_birthday;
        P_phone = p_phone;
        P_numbering = p_numbering;
    }

    public long getP_no() {
        return P_no;
    }

    public void setP_no(long p_no) {
        P_no = p_no;
    }

    public String getP_name() {
        return P_name;
    }

    public void setP_name(String p_name) {
        P_name = p_name;
    }

    public String getP_sex() {
        return P_sex;
    }

    public void setP_sex(String p_sex) {
        P_sex = p_sex;
    }

    public Date getP_birthday() {
        return P_birthday;
    }

    public void setP_birthday(Date p_birthday) {
        P_birthday = p_birthday;
    }

    public String getP_phone() {
        return P_phone;
    }

    public void setP_phone(String p_phone) {
        P_phone = p_phone;
    }

    public long getP_numbering() {
        return P_numbering;
    }

    public void setP_numbering(long p_numbering) {
        P_numbering = p_numbering;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Policemen policemen = (Policemen) o;
        return P_no == policemen.P_no &&
                P_numbering == policemen.P_numbering &&
                P_name.equals(policemen.P_name) &&
                P_sex.equals(policemen.P_sex) &&
                P_birthday.equals(policemen.P_birthday) &&
                P_phone.equals(policemen.P_phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(P_no, P_name, P_sex, P_birthday, P_phone, P_numbering);
    }

    @Override
    public String toString() {
        return "Policemen{" +
                "P_no=" + P_no +
                ", P_name='" + P_name + '\'' +
                ", P_sex='" + P_sex + '\'' +
                ", P_birthday=" + P_birthday +
                ", P_phone='" + P_phone + '\'' +
                ", P_numbering=" + P_numbering +
                '}';
    }
}
