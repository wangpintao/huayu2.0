package com.huayu.bean;

import java.util.Set;

public class Role {
    private Integer rid;
    private String rolename;
    private Set<Student> stulist;

    public Set<Student> getStulist() {
        return stulist;
    }

    public void setStulist(Set<Student> stulist) {
        this.stulist = stulist;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @Override
    public String toString() {
        return "Role{" +
                "rid=" + rid +
                ", rolename='" + rolename + '\'' +
                ", stulist=" + stulist +
                '}';
    }
}
