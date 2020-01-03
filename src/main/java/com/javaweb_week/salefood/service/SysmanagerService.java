package com.javaweb_week.salefood.service;
import java.util.List;
import com.javaweb_week.salefood.entity.Sysmanager;
public interface SysmanagerService{
    long getSysmanagerRowCount();
    List<Sysmanager> selectSysmanager();
    Sysmanager selectSysmanagerById(Integer id);
    int insertSysmanager(Sysmanager value);
    int deleteSysmanagerById(Integer id);
    int updateSysmanagerById(Sysmanager enti);
    //登录方法
    Sysmanager SysManagerLogin(String smusername, String smpassword);
}