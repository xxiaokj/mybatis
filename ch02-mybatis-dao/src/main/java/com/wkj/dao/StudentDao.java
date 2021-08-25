package com.wkj.dao;

import com.wkj.domain.Student;

import java.util.List;

public interface StudentDao {
    List<Student> selectStudents();
    int insertStudent(Student student);
}
