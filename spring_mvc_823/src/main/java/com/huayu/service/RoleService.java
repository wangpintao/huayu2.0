package com.huayu.service;

import com.huayu.bean.Role;
import com.huayu.bean.Student;
import com.huayu.dao.IdRoleimpl;
import com.huayu.dao.IdStudentimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 添加学生角色
 */
@Component
@Transactional
public class RoleService {
    @Autowired
    private IdRoleimpl idRoleimpl;
    private int[] roleid;
    @Resource(name = "hibernateTemplate")
    private HibernateTemplate hibernateTemplate;
    @Resource(name = "studentDao")
    private IdStudentimpl studentimpl;

    public IdStudentimpl getStudentimpl() {
        return studentimpl;
    }

    public void setStudentimpl(IdStudentimpl studentimpl) {
        this.studentimpl = studentimpl;
    }

    public int[] getRoleid() {
        return roleid;
    }

    public void setRoleid(int[] roleid) {
        this.roleid = roleid;
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public IdRoleimpl getIdRoleimpl() {
        return idRoleimpl;
    }

    public void setIdRoleimpl(IdRoleimpl idRoleimpl) {
        this.idRoleimpl = idRoleimpl;
    }

    public int add(Student student, int[] roleid){
        for (int i=0;i<roleid.length;i++){
            Role role = hibernateTemplate.get(Role.class,roleid[i]);
            student.getRolelist().add(role);
        }
            return studentimpl.add(student);

    }

    /**
     * 查询所有角色
     * @return
     */
    public List<Role> queryRole(){
        return idRoleimpl.sver();

    }
}
