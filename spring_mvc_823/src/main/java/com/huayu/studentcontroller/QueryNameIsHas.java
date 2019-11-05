package com.huayu.studentcontroller;

import com.huayu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QueryNameIsHas {
    @Autowired
    private StudentService studentService;
    /**
     * 判断用户名是否存在或有值
     */
    public void queryNameIsHas(HttpServletResponse response,String name){
        boolean f = studentService.queryNameIsHas(name);
        try {
            response.getWriter().write(f+"");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
