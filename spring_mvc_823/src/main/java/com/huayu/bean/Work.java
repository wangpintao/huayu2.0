package com.huayu.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Work {
    private String wid;
    private String wname;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date newtdtime;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date timetime;
    private String duty;
    private Integer sid;

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid;
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }

    public Date getNewtdtime() {
        return newtdtime;
    }

    public void setNewtdtime(Date newtdtime) {
        this.newtdtime = newtdtime;
    }

    public Date getTimetime() {
        return timetime;
    }

    public void setTimetime(Date timetime) {
        this.timetime = timetime;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "Work{" +
                "wid='" + wid + '\'' +
                ", wname='" + wname + '\'' +
                ", newtdtime=" + newtdtime +
                ", timetime=" + timetime +
                ", duty='" + duty + '\'' +
                ", sid=" + sid +
                '}';
    }
}
