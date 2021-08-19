package com.bjpowernode.controller;

import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;


@Controller
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentService service;
    //注册学生
    @RequestMapping("addStudent.do")
    public ModelAndView add(Student student){
        ModelAndView mv = new ModelAndView();
        String tips = "注册失败";
        int nums = service.addStudent(student);
        if(nums > 0){
            tips=student.getName()+"注册成功";
        }
        mv.addObject("tips",tips);
        mv.setViewName("result");
        return mv;
    }

    //处理查询，响应ajax
    @RequestMapping("/queryStudent.do")
    @ResponseBody
    public List<Student> queryStudent(){
        List<Student> student = service.findStudent();
        return student;
    }
}
