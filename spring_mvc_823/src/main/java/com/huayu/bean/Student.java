package com.huayu.bean;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Student {
    private Integer gid;
    private Integer sid;
    @Size(min = 2,max = 5,message = "{items.stuname.size}")
    private String stuname;
    private String sex;
    private Integer age;
    private Grade gd;
    @Email(regexp = "([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$",message = "{items.mailbox.email}")
    private String mailbox;
    private Set<Role> rolelist =new HashSet<>();
    private List<Work> workList;

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public List<Work> getWorkList() {
        return workList;
    }

    public void setWorkList(List<Work> workList) {
        this.workList = workList;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Grade getGd() {
        return gd;
    }

    public void setGd(Grade gd) {
        this.gd = gd;
    }

    public Set<Role> getRolelist() {
        return rolelist;
    }

    public void setRolelist(Set<Role> rolelist) {
        this.rolelist = rolelist;
    }

    @Override
    public String toString() {
        return "Student{" +
                "gid=" + gid +
                ", sid=" + sid +
                ", stuname='" + stuname + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", mailbox='" + mailbox + '\'' +
                '}';
    }
}
