package com.huayu.studentcontroller;

import com.huayu.abnormal.MyException;
import com.huayu.bean.*;
import com.huayu.service.*;
import com.mchange.v2.sql.filter.SynchronizedFilterDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.print.attribute.standard.Sides;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private GradeService gradeService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private WorkService workService;
    @Autowired
    private LoginService loginService;
    private ModelAndView modelAndView = new ModelAndView();
    /**
     * 查询所有学生
     */
    @RequestMapping("/queryAll.do")
   /* @RequestBody*/
    public ModelAndView queryAll(Student student)throws MyException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list",studentService.sver(student));
        modelAndView.setViewName("index.jsp");
        return modelAndView;
    }
    /**
     * 添加
     * @return
     */
    @RequestMapping("/add.do")
    public String add(@Validated Student student, BindingResult result,int[] roleid, Model model){
        if(result.hasErrors()){
            model.addAttribute("erros",result.getAllErrors());
            model.addAttribute("gradeList",gradeService.sver());
            model.addAttribute("rolelist",roleService.queryRole());
            return "insert.jsp";
        }
        Integer sid = roleService.add(student,roleid);
        workService.add(student.getWorkList(),sid);
        return "redirect:queryAll.do";
    }
    /**
     * 去添加
     */
    @RequestMapping("/toadd.do")
    public ModelAndView toadd(){
        modelAndView.addObject("gradeList",gradeService.sver());
        modelAndView.addObject("rolelist",roleService.queryRole());
        modelAndView.setViewName("insert.jsp");
        return modelAndView;
    }

    /**
     * 删除
     */
    @DeleteMapping("/{sid}.do")
    public String delete(@PathVariable("sid")Integer sid){
        Student student = new Student();
        student.setSid(sid);
        studentService.delect(student);
        return"redirect:queryAll.do";
    }
    /**
     * 修改
     */
        @RequestMapping(value = "/add.do",method = RequestMethod.PUT)
        public String updete(Student stu){
        studentService.update(stu);
        return "redirect:queryAll.do";
    }

    /**
     * 根据id去修改
     * @return
     */
    @RequestMapping("/toupdate")
    public ModelAndView toupdate(Integer sid){
        modelAndView.addObject("stu",studentService.b(sid));
        modelAndView.addObject("gradeList",gradeService.sver());
        modelAndView.addObject("rolelist",roleService.queryRole());
        modelAndView.setViewName("update.jsp");
        return modelAndView;
    }
    /**
     * 选项删除
     */
    @RequestMapping("/wholedelete.do")
    public String wholedelete(Integer[] sid){
        for (int i=0;i<sid.length;i++){
            delete(sid[i]);
        }
        return "redirect:queryAll.do";
    }
    /**
     * 登录
     */
    @RequestMapping("/login.do")
    public String login(HttpSession session,Login login,Model model)throws MyException{
        boolean q = loginService.querylogin(login);
        if (q){
            session.setAttribute("name",login.getUsername());
            return "redirect:queryAll.do";
        }else{
            return "/login.jsp";
        }
    }
}
