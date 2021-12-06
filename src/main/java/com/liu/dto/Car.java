package com.liu.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

/**
 * @Author: LiuYi
 * @Date: 2021/7/3 18:48
 * 汽车实体类
 */
public class Car implements Serializable {
    /**
     * 汽车ID号
     */
    private long C_no;

    /**
     * 机动车牌照号
     */
    private String C_number;

    /**
     * 型号
     */
    private String C_model;

    /**
     * 制造商
     */
    private String C_manufacturer;

    /**
     * 生产日期
     */
    private Date C_production_date;

    /**
     * 驾驶人ID
     */
    private long D_no;

    private static final long serialVersionUID = 1L;

    public Car() {
    }

    public Car(String c_number, String c_model, String c_manufacturer, Date c_production_date, long d_no) {
        C_number = c_number;
        C_model = c_model;
        C_manufacturer = c_manufacturer;
        C_production_date = c_production_date;
        D_no = d_no;
    }

    public Car(long c_no, String c_umber, String c_model, String c_manufacturer, Date c_productionDate, long d_no) {
        C_no = c_no;
        C_number = c_umber;
        C_model = c_model;
        C_manufacturer = c_manufacturer;
        C_production_date = c_productionDate;
        D_no = d_no;
    }

    public long getC_no() {
        return C_no;
    }

    public void setC_no(long c_no) {
        C_no = c_no;
    }

    public String getC_number() {
        return C_number;
    }

    public void setC_number(String c_number) {
        C_number = c_number;
    }

    public String getC_model() {
        return C_model;
    }

    public void setC_model(String c_model) {
        C_model = c_model;
    }

    public String getC_manufacturer() {
        return C_manufacturer;
    }

    public void setC_manufacturer(String c_manufacturer) {
        C_manufacturer = c_manufacturer;
    }

    public Date getC_production_date() {
        return C_production_date;
    }

    public void setC_production_date(Date c_production_date) {
        C_production_date = c_production_date;
    }

    public long getD_no() {
        return D_no;
    }

    public void setD_no(long d_no) {
        D_no = d_no;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return C_no == car.C_no &&
                D_no == car.D_no &&
                C_number.equals(car.C_number) &&
                C_model.equals(car.C_model) &&
                C_manufacturer.equals(car.C_manufacturer) &&
                C_production_date.equals(car.C_production_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(C_no, C_number, C_model, C_manufacturer, C_production_date, D_no);
    }

    @Override
    public String toString() {
        return "Car{" +
                "C_no=" + C_no +
                ", C_umber='" + C_number + '\'' +
                ", C_model='" + C_model + '\'' +
                ", C_manufacturer='" + C_manufacturer + '\'' +
                ", C_productionDate=" + C_production_date +
                ", D_no=" + D_no +
                '}';
    }
}
