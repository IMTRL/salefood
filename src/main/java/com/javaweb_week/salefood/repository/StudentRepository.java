package com.javaweb_week.salefood.repository;

import com.javaweb_week.salefood.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository//使用注解，之后好在满足JPA方法命名规则的情况下快速生成自己想要的查询方法
public interface StudentRepository extends JpaRepository<Student,Integer> {//继承JpaRepository得到JPA封装好的一些数据库查询方法
    List<Student> findStudentBySid(int sid);//根据学生id查询学生
    List<Student> findStudentBySidAndSpassword(int sid,String spassword);//根据学生id和密码查询学生
    @Query(value = "update student set spassword=?1 where sid=?2", nativeQuery = true)
    @Modifying
    @Transactional
    void updateStudentSpassword(String spassword,int sid);
}
