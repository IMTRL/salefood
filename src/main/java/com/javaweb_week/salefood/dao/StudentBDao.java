package com.javaweb_week.salefood.dao;
import com.javaweb_week.salefood.entity.StudentB;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentBDao{
    long getStudentBRowCount();
    List<StudentB> selectStudentB();
    StudentB selectStudentBById(Integer id);
    int insertStudentB(StudentB value);

    int deleteStudentBById(Integer id);
    int updateStudentBById(StudentB enti);

}