package com.huayu.service;

import com.huayu.abnormal.MyException;
import com.huayu.bean.Student;
import com.huayu.dao.IdStudentimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class StudentService {
    @Autowired
    private IdStudentimpl studentimpl;
    public IdStudentimpl getStudentimpl() {
        return studentimpl;
    }
    public void setStudentimpl(IdStudentimpl studentimpl) {
        this.studentimpl = studentimpl;
    }
    //查询所有学生
    public List<Student> sver(Student student) /*throws MyException*/{
      /*  try {
            int i = 1/0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new MyException("撒比");
        }*/
        return studentimpl.sver(student);
        /*if(currentpage==null){
            currentpage=1;
        }
        StringBuffer stringBuffer = new StringBuffer("from Student where 1=1");
        if(null !=student){
            if(null !=student.getStuname() && !"".equals(student.getStuname())){
                stringBuffer.append( " and stunamei like '%"+student.getStuname()+"%'");
            }

            if(null !=student.getSex() && !"".equals(student.getSex()) ){
                stringBuffer.append( "  and sex='"+student.getSex()+"'");
            }

            if(null !=student.getGid() && !"".equals(student.getGid())){
                stringBuffer.append("  and gid="+student.getGid()+"");
            }


        }
        StudentDao studentDao =new StudentDao();
        int altogether  = studentDao.allrows();
        if(altogether%2==0){
            altogether = altogether/2;
        }else {
            altogether = altogether/2+1;
        }
        ServletActionContext.getRequest().setAttribute("altogether",altogether);
        ServletActionContext.getRequest().setAttribute("currentpage",currentpage);
        return studentimpl.sver(stringBuffer.toString(),currentpage,2);*/
    }
    //修改所以学生
    public void update(Student student){
        studentimpl.update(student);
    }
    //添加学生
    public void add(Student student){
        studentimpl.add(student);
    }
    //删除学生
    public void delect(Student student){
        studentimpl.delete(student);
    }
    //根据id来查询学生
    public Student b(Integer sid){
        return  studentimpl.sverid(sid);
    }
    /**
     * 判断用户名是否存在或有值
     */
    public boolean queryNameIsHas(String name){
        boolean flag=false;
        List<Student> list =  studentimpl.queryNameIsHas(name);
        if(list.size()>0){
            flag=true;
        }
        return flag;
    }
}
