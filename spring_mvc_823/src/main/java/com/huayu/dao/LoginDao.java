package com.huayu.dao;

import com.huayu.bean.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;


import java.util.List;
@Component
public class LoginDao implements IdLoginimpl{
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
    @Override
    public List<Login> sver(Login login){
        List<Login> list=(List<Login>) hibernateTemplate.find("from Login where username= '"+login.getUsername()+"'and password ='"+login.getPassword()+"'");
        return list;
    }
}
