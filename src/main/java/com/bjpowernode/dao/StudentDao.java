package com.bjpowernode.dao;

import com.bjpowernode.domain.Student;

import java.util.List;

public interface StudentDao {
    int insertStudents(Student student);
    List<Student> selectStudents();
}
