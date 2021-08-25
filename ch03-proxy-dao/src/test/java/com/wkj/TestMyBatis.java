package com.wkj;

import com.github.pagehelper.PageHelper;
import com.wkj.dao.StudentDao;
import com.wkj.domain.Student;
import com.wkj.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestMyBatis {
    @Test
    public  void testselectStudens(){
       //使用mybatis的动态代理机制，使用SqlSession.getMapper(dao接口)
        //getMapper能获取dao接口对于实现类对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        //System.out.println("dao="+dao.getClass().getName());

        //加入PageHelper的方法，分页
        PageHelper.startPage(2,3);
        //调用dao的方法来执行数据库的操作
        List<Student> studentList = dao.selectStudents();
        for (Student stu:studentList){
            System.out.println("学生："+stu);
        }
    }
    @Test
    public void testinsertStudent(){
        //使用mybatis的动态代理机制，使用SqlSession.getMapper(dao接口)
        //getMapper能获取dao接口对于实现类对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        //调用dao的方法来执行数据库的操作
        Student student = new Student(1007,"李飞","lf@qq.com",25);
        int res = dao.insertStudent(student);
        sqlSession.commit();
        sqlSession.close();
        System.out.println("添加对象的数量："+res);
    }

    @Test
    public void testSelectMuliParem(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectMuliParam("李四",25);
        for (Student stu:students){
            System.out.println("学生："+stu);
        }
        sqlSession.close();
    }
}
