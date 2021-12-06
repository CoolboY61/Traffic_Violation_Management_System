package com.liu.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * 
 * @TableName view_ticket
 */
public class ViewTicket implements Serializable {
    /**
     * 
     */
    private long T_no;

    /**
     * 
     */
    private String D_name;

    /**
     * 
     */
    private String D_license_number;

    /**
     * 
     */
    private String D_address;

    /**
     * 
     */
    private long D_postcode;

    /**
     * 
     */
    private String D_phone;

    /**
     * 
     */
    private String C_number;

    /**
     * 
     */
    private String C_model;

    /**
     * 
     */
    private String C_manufacturer;

    /**
     * 
     */
    private Date C_production_date;

    /**
     * 
     */
    private Date T_date;

    /**
     * 
     */
    private Date T_time;

    /**
     * 
     */
    private String T_location;

    /**
     * 
     */
    private String T_record;

    /**
     * 
     */
    private long T_punishment_warning;

    /**
     * 
     */
    private long T_punishment_fine;

    /**
     * 
     */
    private long T_punishment_deduction;

    /**
     * 
     */
    private String P_name;

    /**
     * 
     */
    private long P_no;

    private static final long serialVersionUID = 1L;

    public ViewTicket() {
    }

    public ViewTicket(long t_no, String d_name, String d_license_number, String d_address, long d_postcode, String d_phone, String c_number, String c_model, String c_manufacturer, Date c_production_date, Date t_date, Date t_time, String t_location, String t_record, long t_punishment_warning, long t_punishment_fine, long t_punishment_deduction, String p_name, long p_no) {
        T_no = t_no;
        D_name = d_name;
        D_license_number = d_license_number;
        D_address = d_address;
        D_postcode = d_postcode;
        D_phone = d_phone;
        C_number = c_number;
        C_model = c_model;
        C_manufacturer = c_manufacturer;
        C_production_date = c_production_date;
        T_date = t_date;
        T_time = t_time;
        T_location = t_location;
        T_record = t_record;
        T_punishment_warning = t_punishment_warning;
        T_punishment_fine = t_punishment_fine;
        T_punishment_deduction = t_punishment_deduction;
        P_name = p_name;
        P_no = p_no;
    }

    /**
     * 
     */
    public long getT_no() {
        return T_no;
    }

    /**
     * 
     */
    public void setT_no(long t_no) {
        this.T_no = t_no;
    }

    /**
     * 
     */
    public String getD_name() {
        return D_name;
    }

    /**
     * 
     */
    public void setD_name(String d_name) {
        this.D_name = d_name;
    }

    /**
     * 
     */
    public String getD_license_number() {
        return D_license_number;
    }

    /**
     * 
     */
    public void setD_license_number(String d_license_number) {
        this.D_license_number = d_license_number;
    }

    /**
     * 
     */
    public String getD_address() {
        return D_address;
    }

    /**
     * 
     */
    public void setD_address(String d_address) {
        this.D_address = d_address;
    }

    /**
     * 
     */
    public long getD_postcode() {
        return D_postcode;
    }

    /**
     * 
     */
    public void setD_postcode(long d_postcode) {
        this.D_postcode = d_postcode;
    }

    /**
     * 
     */
    public String getD_phone() {
        return D_phone;
    }

    /**
     * 
     */
    public void setD_phone(String d_phone) {
        this.D_phone = d_phone;
    }

    /**
     * 
     */
    public String getC_number() {
        return C_number;
    }

    /**
     * 
     */
    public void setC_number(String c_number) {
        this.C_number = c_number;
    }

    /**
     * 
     */
    public String getC_model() {
        return C_model;
    }

    /**
     * 
     */
    public void setC_model(String c_model) {
        this.C_model = c_model;
    }

    /**
     * 
     */
    public String getC_manufacturer() {
        return C_manufacturer;
    }

    /**
     * 
     */
    public void setC_manufacturer(String c_manufacturer) {
        this.C_manufacturer = c_manufacturer;
    }

    /**
     * 
     */
    public Date getC_production_date() {
        return C_production_date;
    }

    /**
     * 
     */
    public void setC_production_date(Date c_production_date) {
        this.C_production_date = c_production_date;
    }

    /**
     * 
     */
    public Date getT_date() {
        return T_date;
    }

    /**
     * 
     */
    public void setT_date(Date t_date) {
        this.T_date = t_date;
    }

    /**
     * 
     */
    public Date getT_time() {
        return T_time;
    }

    /**
     * 
     */
    public void setT_time(Date t_time) {
        this.T_time = t_time;
    }

    /**
     * 
     */
    public String getT_location() {
        return T_location;
    }

    /**
     * 
     */
    public void setT_location(String t_location) {
        this.T_location = t_location;
    }

    /**
     * 
     */
    public String getT_record() {
        return T_record;
    }

    /**
     * 
     */
    public void setT_record(String t_record) {
        this.T_record = t_record;
    }

    /**
     * 
     */
    public long getT_punishment_warning() {
        return T_punishment_warning;
    }

    /**
     * 
     */
    public void setT_punishment_warning(long t_punishment_warning) {
        this.T_punishment_warning = t_punishment_warning;
    }

    /**
     * 
     */
    public long getT_punishment_fine() {
        return T_punishment_fine;
    }

    /**
     * 
     */
    public void setT_punishment_fine(long t_punishment_fine) {
        this.T_punishment_fine = t_punishment_fine;
    }

    /**
     * 
     */
    public long getT_punishment_deduction() {
        return T_punishment_deduction;
    }

    /**
     * 
     */
    public void setT_punishment_deduction(long t_punishment_deduction) {
        this.T_punishment_deduction = t_punishment_deduction;
    }

    /**
     * 
     */
    public String getP_name() {
        return P_name;
    }

    /**
     * 
     */
    public void setP_name(String p_name) {
        this.P_name = p_name;
    }

    /**
     * 
     */
    public long getP_no() {
        return P_no;
    }

    /**
     * 
     */
    public void setP_no(long p_no) {
        this.P_no = p_no;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ViewTicket that = (ViewTicket) o;
        return T_no == that.T_no &&
                D_postcode == that.D_postcode &&
                T_punishment_warning == that.T_punishment_warning &&
                T_punishment_fine == that.T_punishment_fine &&
                T_punishment_deduction == that.T_punishment_deduction &&
                P_no == that.P_no &&
                D_name.equals(that.D_name) &&
                D_license_number.equals(that.D_license_number) &&
                D_address.equals(that.D_address) &&
                D_phone.equals(that.D_phone) &&
                C_number.equals(that.C_number) &&
                C_model.equals(that.C_model) &&
                C_manufacturer.equals(that.C_manufacturer) &&
                C_production_date.equals(that.C_production_date) &&
                T_date.equals(that.T_date) &&
                T_time.equals(that.T_time) &&
                T_location.equals(that.T_location) &&
                T_record.equals(that.T_record) &&
                P_name.equals(that.P_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(T_no, D_name, D_license_number, D_address, D_postcode, D_phone, C_number, C_model, C_manufacturer, C_production_date, T_date, T_time, T_location, T_record, T_punishment_warning, T_punishment_fine, T_punishment_deduction, P_name, P_no);
    }

    @Override
    public String toString() {
        return "ViewTicket{" +
                "tNo=" + T_no +
                ", dName='" + D_name + '\'' +
                ", dLicenseNumber='" + D_license_number + '\'' +
                ", dAddress='" + D_address + '\'' +
                ", dPostcode=" + D_postcode +
                ", dPhone='" + D_phone + '\'' +
                ", cNumber='" + C_number + '\'' +
                ", cModel='" + C_model + '\'' +
                ", cManufacturer='" + C_manufacturer + '\'' +
                ", cProductionDate=" + C_production_date +
                ", tDate=" + T_date +
                ", tTime=" + T_time +
                ", tLocation='" + T_location + '\'' +
                ", tRecord='" + T_record + '\'' +
                ", tPunishmentWarning=" + T_punishment_warning +
                ", tPunishmentFine=" + T_punishment_fine +
                ", tPunishmentDeduction=" + T_punishment_deduction +
                ", pName='" + P_name + '\'' +
                ", pNo=" + P_no +
                '}';
    }
}