package com.wkj;

import com.wkj.dao.StudentDao;
import com.wkj.dao.impl.StudentDaoImpl;
import com.wkj.domain.Student;
import org.junit.Test;

import java.util.List;

public class TestMyBatis {
    @Test
    public  void testselectStudens(){
        StudentDao dao = new StudentDaoImpl();
        List<Student> studentList = dao.selectStudents();
        for (Student stu:studentList){
            System.out.println(stu);
        }
    }
    @Test
    public void testinsertStudent(){
        StudentDao dao = new StudentDaoImpl();
        Student student = new Student(1006,"顿山","ds@qq.com",23);
        int nums =  dao.insertStudent(student);
        System.out.println("添加对象的数量："+nums);
    }
}
