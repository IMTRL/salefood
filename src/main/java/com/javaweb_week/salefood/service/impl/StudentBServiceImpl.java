package com.javaweb_week.salefood.service.impl;
import java.util.List;
import com.javaweb_week.salefood.dao.StudentBDao;
import com.javaweb_week.salefood.entity.StudentB;
import com.javaweb_week.salefood.service.StudentBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentBServiceImpl implements StudentBService{
    @Autowired
    private StudentBDao studentBDao;
    @Override
    public long getStudentBRowCount(){
        return studentBDao.getStudentBRowCount();
    }
    @Override
    public List<StudentB> selectStudentB(){
        return studentBDao.selectStudentB();
    }
    @Override
    public StudentB selectStudentBById(Integer id){
        return studentBDao.selectStudentBById(id);
    }
    @Override
    public int insertStudentB(StudentB value){
        return studentBDao.insertStudentB(value);
    }

    @Override
    public int deleteStudentBById(Integer id){
        return studentBDao.deleteStudentBById(id);
    }
    @Override
    public int updateStudentBById(StudentB enti){
        return studentBDao.updateStudentBById(enti);
    }


    public StudentBDao getStudentBDao() {
        return this.studentBDao;
    }

    public void setStudentBDao(StudentBDao studentBDao) {
        this.studentBDao = studentBDao;
    }

}