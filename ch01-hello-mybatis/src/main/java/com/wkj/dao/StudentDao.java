package com.wkj.dao;

import com.wkj.domain.Student;

import java.util.List;

//接口操作student表
public interface StudentDao {
    //查询student表所有数据
    public List<Student> selectStudents();

    public int insertStudent(Student student);
}
