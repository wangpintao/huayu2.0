package com.huayu.service;

import com.huayu.bean.Login;
import com.huayu.dao.IdLoginimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class LoginService {
    @Autowired
    private IdLoginimpl idLoginimpl;

    public IdLoginimpl getIdLoginimpl() {
        return idLoginimpl;
    }

    public void setIdLoginimpl(IdLoginimpl idLoginimpl) {
        this.idLoginimpl = idLoginimpl;
    }
    public boolean querylogin(Login login){
        boolean i = false;
        List<Login>List =idLoginimpl.sver(login);
        if(List.size()>0){
            i= true;
        }else {
        i =false;
        }
        return i;
    }
}
