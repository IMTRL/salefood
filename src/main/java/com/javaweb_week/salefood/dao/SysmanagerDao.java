package com.javaweb_week.salefood.dao;
import com.javaweb_week.salefood.entity.Sysmanager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SysmanagerDao{
    long getSysmanagerRowCount();
    List<Sysmanager> selectSysmanager();
    Sysmanager selectSysmanagerById(Integer id);
    int insertSysmanager(Sysmanager value);
    int deleteSysmanagerById(Integer id);
    int updateSysmanagerById(Sysmanager enti);

    //登录方法
    Sysmanager SysManagerLogin(@Param("smusername") String smusername, @Param("smpassword") String smpassword);
}