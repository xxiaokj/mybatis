package com.wkj.dao.impl;

import com.wkj.dao.StudentDao;
import com.wkj.domain.Student;
import com.wkj.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> selectStudents() {
        //获取SqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        String sqlId = "com.wkj.dao.StudentDao.selectStudents";
        //执行sql语句
        List<Student> studentList = sqlSession.selectList(sqlId);
        //关闭
        sqlSession.close();
        return studentList;
    }

    @Override
    public int insertStudent(Student student) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        String SqlId = "com.wkj.dao.StudentDao.insertStudent";
        int res = sqlSession.insert(SqlId,student);
        sqlSession.commit();
        sqlSession.close();
        return res;
    }
}
