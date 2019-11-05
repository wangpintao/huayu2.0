package com.huayu.dao;

import com.huayu.bean.Student;

import java.util.List;

public interface IdStudentimpl {

    public List<Student> sver(Student student);
    /**
     * 修改
     */
    public void update(Student student);
    /**
     * 添加
     */
    public int add(Student student);
    /**
     * 删除
     */
    public void delete(Student student);

    /**
     * 去修改id查询
     */
    public Student sverid(Integer sid);
    /**
     * 查询所有行
     */
/*    public int allrows();*/
    /**
     * 判断用户名是否存在或有值
     */
    public List<Student> queryNameIsHas(String name);
}

