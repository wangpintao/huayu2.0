package com.huayu.dao;

import com.huayu.bean.Role;
import com.huayu.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoleDao implements IdRoleimpl {
    @Autowired
    private HibernateTemplate hibernateTemplate;
    private int[] roleid;
    private Student student;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public int[] getRoleid() {
        return roleid;
    }

    public void setRoleid(int[] roleid) {
        this.roleid = roleid;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public List<Role> sver() {
        return  (List<Role>)hibernateTemplate.find("from Role");
    }

    @Override
    public int insert(Student student, int[] roleid) {
        return (int)hibernateTemplate.save(student);
    }
}
