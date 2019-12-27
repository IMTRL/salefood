package com.javaweb_week.salefood.service;
import java.util.List;
import com.javaweb_week.salefood.entity.Rstmanager;

public interface RstmanagerService{
    long getRstmanagerRowCount();
    List<Rstmanager> selectRstmanager();
    Rstmanager selectRstmanagerById(Integer id);
    int insertRstmanager(Rstmanager value);
    int deleteRstmanagerById(Integer id);
    int updateRstmanagerById(Rstmanager enti);
    //登录方法
    Rstmanager RstManagerLogin(String rmusername, String rmpassword);
}