package com.huayu.service;

import com.huayu.bean.Work;
import com.huayu.dao.IdWorkimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class WorkService {
    @Autowired
    private IdWorkimpl idWorkimpl;

    public IdWorkimpl getIdWorkimpl() {
        return idWorkimpl;
    }

    public void setIdWorkimpl(IdWorkimpl idWorkimpl) {
        this.idWorkimpl = idWorkimpl;
    }
    public void add(List<Work> workList, Integer sid){
        idWorkimpl.add(workList, sid);
    }
}
