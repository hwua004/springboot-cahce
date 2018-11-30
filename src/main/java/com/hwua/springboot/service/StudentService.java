package com.hwua.springboot.service;

import com.hwua.springboot.entity.Student;

public interface StudentService {

    public Student addStudent(Student stu);

    public int delStudent(int id);

    public Student updateStudent(Student stu);

    public Student queryById(int id);

}
