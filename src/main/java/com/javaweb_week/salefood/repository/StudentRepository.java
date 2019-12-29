package com.javaweb_week.salefood.repository;

import com.javaweb_week.salefood.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findStudentBySid(int sid);
    List<Student> findStudentBySidAndSpassword(int sid,String spassword);
    @Query(value = "update student set spassword=?1 where sid=?2", nativeQuery = true)
    @Modifying
    @Transactional
    void updateStudentSpassword(String spassword,int sid);

}
