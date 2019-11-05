package com.huayu.dao;

import com.huayu.bean.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GradeDao implements IdGradeimpl {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
    /**
     * 查询所有班级
     * @return
     */
    @Override
    public List<Grade> sver() {
       return (List<Grade>)hibernateTemplate.find("from Grade");
    }

    /*@Override
    public void gradeAdd(Grade grade) {
        hibernateTemplate.save(grade);
    }*/
}
