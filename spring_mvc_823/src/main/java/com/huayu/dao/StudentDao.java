package com.huayu.dao;

import com.huayu.bean.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentDao implements IdStudentimpl {
    private Integer currentpage;
    private int size;
    @Autowired
    private HibernateTemplate hibernateTemplate;
    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public Integer getCurrentpage() {
        return currentpage;
    }

    public void setCurrentpage(Integer currentpage) {
        this.currentpage = currentpage;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;

    }

    @Override
    public List<Student> sver(Student student) {/*
        Session session = hibernateTemplate.getSessionFactory().openSession();
        Query query = session.createQuery(sql);
        query.setFirstResult((currentpage-1)*size);
        query.setMaxResults(size);
        List<Student> list =query .list();
        return list;*/
        return (List<Student>)hibernateTemplate.find("from Student ");

    }
     //修改
    @Override
    public void update(Student student) {
        hibernateTemplate.update(student);

    }

    @Override
    public int add(Student student) {
        return (int)hibernateTemplate.save(student);
    }

    @Override
    public void delete( Student student) {
        hibernateTemplate.delete(student);

    }
     //去修改
    @Override
    public Student sverid(Integer sid) {
        return (Student) hibernateTemplate.get(Student.class,sid);
        }
    //查询所有行
   /* @Override*/
/*    public int allrows() {
        Session session = hibernateTemplate.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Student.class);
        criteria.setProjection(Projections.count("sid"));
        Long l =(Long)criteria.uniqueResult();
        return l.intValue();
    }*/
    /**
     * 判断用户名是否存在或有值
     */
    public List<Student> queryNameIsHas(String name) {

        return (List<Student>)hibernateTemplate.find("from Student where stuname='"+name+"'");

    }
}
