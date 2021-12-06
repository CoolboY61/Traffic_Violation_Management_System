package com.liu.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @Author: LiuYi
 * @Date: 2021/7/3 18:36
 * 司机的实体类
 */

public class Driver implements Serializable {
    /**
     * ID号
     */
    private long D_no;

    /**
     * 姓名
     */
    private String D_name;

    /**
     * 性别
     */
    private String D_sex;

    /**
     * 出生日期
     */
    private Date D_birthday;

    /**
     * 电话
     */
    private String D_phone;

    /**
     * 驾照号
     */
    private String D_license_number;

    /**
     * 邮编
     */
    private long D_postcode;

    /**
     * 地址
     */
    private String D_address;

    private static final long serialVersionUID = 1L;

    public Driver() {
    }

    public Driver(String d_name, String d_sex, Date d_birthday, String d_phone, String d_license_number, long d_postcode, String d_address) {
        D_name = d_name;
        D_sex = d_sex;
        D_birthday = d_birthday;
        D_phone = d_phone;
        D_license_number = d_license_number;
        D_postcode = d_postcode;
        D_address = d_address;
    }

    public Driver(long d_no, String d_name, String d_sex, Date d_birthday, String d_phone, String d_license_number, long d_postcode, String d_address) {
        D_no = d_no;
        D_name = d_name;
        D_sex = d_sex;
        D_birthday = d_birthday;
        D_phone = d_phone;
        D_license_number = d_license_number;
        D_postcode = d_postcode;
        D_address = d_address;
    }

    public long getD_no() {
        return D_no;
    }

    public void setD_no(long d_no) {
        D_no = d_no;
    }

    public String getD_name() {
        return D_name;
    }

    public void setD_name(String d_name) {
        D_name = d_name;
    }

    public String getD_sex() {
        return D_sex;
    }

    public void setD_sex(String d_sex) {
        D_sex = d_sex;
    }

    public Date getD_birthday() {
        return D_birthday;
    }

    public void setD_birthday(Date d_birthday) {
        D_birthday = d_birthday;
    }

    public String getD_phone() {
        return D_phone;
    }

    public void setD_phone(String d_phone) {
        D_phone = d_phone;
    }

    public String getD_license_number() {
        return D_license_number;
    }

    public void setD_license_number(String d_license_number) {
        D_license_number = d_license_number;
    }

    public long getD_postcode() {
        return D_postcode;
    }

    public void setD_postcode(long d_postcode) {
        D_postcode = d_postcode;
    }

    public String getD_address() {
        return D_address;
    }

    public void setD_address(String d_address) {
        D_address = d_address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Driver driver = (Driver) o;
        return D_no == driver.D_no &&
                D_postcode == driver.D_postcode &&
                D_name.equals(driver.D_name) &&
                D_sex.equals(driver.D_sex) &&
                D_birthday.equals(driver.D_birthday) &&
                D_phone.equals(driver.D_phone) &&
                D_license_number.equals(driver.D_license_number) &&
                D_address.equals(driver.D_address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(D_no, D_name, D_sex, D_birthday, D_phone, D_license_number, D_postcode, D_address);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "D_no=" + D_no +
                ", D_name='" + D_name + '\'' +
                ", D_sex='" + D_sex + '\'' +
                ", D_birthday=" + D_birthday +
                ", D_phone='" + D_phone + '\'' +
                ", D_license_number='" + D_license_number + '\'' +
                ", D_postcode=" + D_postcode +
                ", D_address='" + D_address + '\'' +
                '}';
    }
}

