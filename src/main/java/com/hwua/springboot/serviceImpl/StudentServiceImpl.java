package com.hwua.springboot.serviceImpl;

import com.hwua.springboot.dao.StudentDao;
import com.hwua.springboot.entity.Student;
import com.hwua.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public Student addStudent(Student stu) {
        studentDao.addStudent(stu);
        return stu;
    }

    @Override
    @CacheEvict(value="stu",key = "'stu-'+#id")
    public int delStudent(int id) {
        return studentDao.delStudent(id);
    }

    @Override
    @CachePut(value = "stu",key="'stu-'+#stu.id")
    public Student updateStudent(Student stu) {
        studentDao.updateStudent(stu);
        return stu;
    }

    @Override
    @Cacheable(value = "stu",key = "'stu-'+#id")
    public Student queryById(int id) {
        return studentDao.queryById(id);
    }
}
