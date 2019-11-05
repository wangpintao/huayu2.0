package com.huayu.dao;

import com.huayu.bean.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WorkDao implements IdWorkimpl{
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
    public void add(List<Work> workList,Integer sid){
        for (int i=0;i<workList.size();i++){
            Work work = workList.get(i);
            work.setSid(sid);
            hibernateTemplate.save(work);
        }

    }
}
