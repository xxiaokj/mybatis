package com.wkj;

import com.wkj.domain.Student;
import com.wkj.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MainApp2 {
    public static void main(String[] args) throws IOException {

        //获取SqlSession对象，从SqlSessionFactory中获取SqlSession
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //指定要执行的sql语句的标识，sql映射文件中的namespace+"."+标签的id值
        String sqlId = "com.wkj.dao.StudentDao.selectStudents";
        //执行sql语句，通过sqlId找到语句
        List<Student> studentList = sqlSession.selectList(sqlId);
        //8、输出结果
        studentList.forEach(student -> System.out.println(student));
        //9、关闭sqlSession对象
        sqlSession.close();
    }

}
