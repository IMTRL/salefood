package com.javaweb_week.salefood.service;
import java.util.List;
import com.javaweb_week.salefood.entity.StudentB;
public interface StudentBService{
    long getStudentBRowCount();
    List<StudentB> selectStudentB();
    StudentB selectStudentBById(Integer id);
    int insertStudentB(StudentB value);
    int deleteStudentBById(Integer id);
    int updateStudentBById(StudentB enti);

}