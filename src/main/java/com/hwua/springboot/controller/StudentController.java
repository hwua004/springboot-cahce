package com.hwua.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hwua.springboot.entity.Student;
import com.hwua.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/student/query/{id}",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String query(@PathVariable("id") int id){
        Student student=studentService.queryById(id);
        return JSON.toJSONString(student);
    }


    @RequestMapping(value = "/student/update/{id}",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String update(@PathVariable("id") int id){
        Student student= new Student();
        student.setId(id);
        student.setCode(Math.random()+"");
        Student stu=studentService.updateStudent(student);
        return JSON.toJSONString(stu);
    }

    @RequestMapping(value = "/student/del/{id}",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String del(@PathVariable("id") int id){
        return studentService.delStudent(id)+"";
    }

}
