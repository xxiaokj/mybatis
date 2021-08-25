package com.wkj.dao;

import com.wkj.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    List<Student> selectStudents();
    int insertStudent(Student student);
    Student selectStudentById(Integer id);
    List<Student> selectMuliParam(@Param("myname") String name, @Param("myage") Integer age);
}
