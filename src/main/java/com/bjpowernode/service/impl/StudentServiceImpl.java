package com.bjpowernode.service.impl;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;
    @Override
    public int addStudent(Student student) {
        int nums = studentDao.insertStudents(student);
        return nums;
    }

    @Override
    public List<Student> findStudent() {
        List<Student> students = studentDao.selectStudents();
        for (Student student : students) {
            System.out.println(student);
        }
        return students;
    }
}
