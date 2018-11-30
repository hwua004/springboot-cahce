package com.hwua.springboot.dao;


import com.hwua.springboot.entity.Student;

public interface StudentDao {

    public int addStudent(Student stu);

    public int delStudent(int id);

    public int updateStudent(Student stu);

    public Student queryById(int id);

}
