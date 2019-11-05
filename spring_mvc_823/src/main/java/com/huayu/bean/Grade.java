package com.huayu.bean;

import java.util.Set;

public class Grade {
    private Integer gid;
    private String ganme;
    private Set<Student> studentlist;

    public Set<Student> getStudentlist() {
        return studentlist;
    }

    public void setStudentlist(Set<Student> studentlist) {
        this.studentlist = studentlist;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGanme() {
        return ganme;
    }

    public void setGanme(String ganme) {
        this.ganme = ganme;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "gid=" + gid +
                ", ganme='" + ganme + '\'' +
                ", studentlist=" + studentlist +
                '}';
    }
}