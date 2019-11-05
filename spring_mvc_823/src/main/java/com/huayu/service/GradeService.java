package com.huayu.service;

import com.huayu.bean.Grade;
import com.huayu.dao.IdGradeimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class GradeService {
    @Autowired
     private IdGradeimpl idGradeimpl;

    public IdGradeimpl getIdGradeimpl() {
        return idGradeimpl;
    }

    public void setIdGradeimpl(IdGradeimpl idGradeimpl) {
        this.idGradeimpl = idGradeimpl;
    }

    /**
     * 查询所有班级
     * @return
     */
    public List<Grade> sver(){
        return  idGradeimpl.sver();
    }
/*    public void add(Grade grade){
        idGradeimpl.gradeAdd(grade);
    }*/
}
