package com.liu.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

/**
 * @Author: LiuYi
 * @Date: 2021/7/3 18:56
 * 罚单实体类
 */
public class Ticket implements Serializable {
    /**
     * 罚单ID号
     */
    private long T_no;

    /**
     * 违章日期
     */
    private Date T_date;

    /**
     * 开罚单的日期
     */
    private Date T_time;

    /**
     * 违章地点
     */
    private String T_location;

    /**
     * 违章记载
     */
    private String T_record;

    /**
     * 处罚—警告
     */
    private long T_punishment_warning;

    /**
     * 处罚—罚款
     */
    private long T_punishment_fine;

    /**
     * 处罚—暂扣驾驭执照
     */
    private long T_punishment_deduction;

    /**
     * 驾驶人确认状态
     */
    private long T_verification;

    /**
     * 驾驶人ID
     */
    private long D_no;

    /**
     * 汽车ID
     */
    private long C_no;

    /**
     * 警员ID
     */
    private long P_no;

    private static final long serialVersionUID = 1L;

    public Ticket() {
    }

    public Ticket(Date t_date, Date t_time, String t_location, String t_record, long t_punishment_warning, long t_punishment_fine, long t_punishment_deduction, long t_verification, long d_no, long c_no, long p_no) {
        T_date = t_date;
        T_time = t_time;
        T_location = t_location;
        T_record = t_record;
        T_punishment_warning = t_punishment_warning;
        T_punishment_fine = t_punishment_fine;
        T_punishment_deduction = t_punishment_deduction;
        T_verification = t_verification;
        D_no = d_no;
        C_no = c_no;
        P_no = p_no;
    }

    public Ticket(long tNo, Date tDate, Date tTime, String tLocation, String tRecord, long tPunishmentWarning, long tPunishmentFine, long tPunishmentDeduction, long tVerification, long dNo, long cNo, long pNo) {
        this.T_no = tNo;
        this.T_date = tDate;
        this.T_time = tTime;
        this.T_location = tLocation;
        this.T_record = tRecord;
        this.T_punishment_warning = tPunishmentWarning;
        this.T_punishment_fine = tPunishmentFine;
        this.T_punishment_deduction = tPunishmentDeduction;
        this.T_verification = tVerification;
        this.D_no = dNo;
        this.C_no = cNo;
        this.P_no = pNo;
    }

    public long getT_no() {
        return T_no;
    }

    public void setT_no(long t_no) {
        this.T_no = t_no;
    }

    public Date getT_date() {
        return T_date;
    }

    public void setT_date(Date t_date) {
        this.T_date = t_date;
    }

    public Date getT_time() {
        return T_time;
    }

    public void setT_time(Date t_time) {
        this.T_time = t_time;
    }

    public String getT_location() {
        return T_location;
    }

    public void setT_location(String t_location) {
        this.T_location = t_location;
    }

    public String getT_record() {
        return T_record;
    }

    public void setT_record(String t_record) {
        this.T_record = t_record;
    }

    public long getT_punishment_warning() {
        return T_punishment_warning;
    }

    public void setT_punishment_warning(long t_punishment_warning) {
        this.T_punishment_warning = t_punishment_warning;
    }

    public long getT_punishment_fine() {
        return T_punishment_fine;
    }

    public void setT_punishment_fine(long t_punishment_fine) {
        this.T_punishment_fine = t_punishment_fine;
    }

    public long getT_punishment_deduction() {
        return T_punishment_deduction;
    }

    public void setT_punishment_deduction(long t_punishment_deduction) {
        this.T_punishment_deduction = t_punishment_deduction;
    }

    public long getT_verification() {
        return T_verification;
    }

    public void setT_verification(long t_verification) {
        this.T_verification = t_verification;
    }

    public long getD_no() {
        return D_no;
    }

    public void setD_no(long d_no) {
        this.D_no = d_no;
    }

    public long getC_no() {
        return C_no;
    }

    public void setC_no(long c_no) {
        this.C_no = c_no;
    }

    public long getP_no() {
        return P_no;
    }

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
        Ticket ticket = (Ticket) o;
        return T_no == ticket.T_no &&
                T_punishment_warning == ticket.T_punishment_warning &&
                T_punishment_fine == ticket.T_punishment_fine &&
                T_punishment_deduction == ticket.T_punishment_deduction &&
                T_verification == ticket.T_verification &&
                D_no == ticket.D_no &&
                C_no == ticket.C_no &&
                P_no == ticket.P_no &&
                T_date.equals(ticket.T_date) &&
                T_time.equals(ticket.T_time) &&
                T_location.equals(ticket.T_location) &&
                T_record.equals(ticket.T_record);
    }

    @Override
    public int hashCode() {
        return Objects.hash(T_no, T_date, T_time, T_location, T_record, T_punishment_warning, T_punishment_fine, T_punishment_deduction, T_verification, D_no, C_no, P_no);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "tNo=" + T_no +
                ", tDate=" + T_date +
                ", tTime=" + T_time +
                ", tLocation='" + T_location + '\'' +
                ", tRecord='" + T_record + '\'' +
                ", tPunishmentWarning=" + T_punishment_warning +
                ", tPunishmentFine=" + T_punishment_fine +
                ", tPunishmentDeduction=" + T_punishment_deduction +
                ", tVerification=" + T_verification +
                ", dNo=" + D_no +
                ", cNo=" + C_no +
                ", pNo=" + P_no +
                '}';
    }
}
