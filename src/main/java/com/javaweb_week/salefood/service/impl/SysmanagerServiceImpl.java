package com.javaweb_week.salefood.service.impl;
import java.util.List;
import com.javaweb_week.salefood.dao.SysmanagerDao;
import com.javaweb_week.salefood.entity.Sysmanager;
import com.javaweb_week.salefood.service.SysmanagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysmanagerServiceImpl implements SysmanagerService{
    @Autowired
    private SysmanagerDao sysmanagerDao;
    @Override
    public long getSysmanagerRowCount(){
        return sysmanagerDao.getSysmanagerRowCount();
    }
    @Override
    public List<Sysmanager> selectSysmanager(){
        return sysmanagerDao.selectSysmanager();
    }
    @Override
    public Sysmanager selectSysmanagerById(Integer id){
        return sysmanagerDao.selectSysmanagerById(id);
    }
    @Override
    public int insertSysmanager(Sysmanager value){
        return sysmanagerDao.insertSysmanager(value);
    }

    @Override
    public int deleteSysmanagerById(Integer id){
        return sysmanagerDao.deleteSysmanagerById(id);
    }
    @Override
    public int updateSysmanagerById(Sysmanager enti){
        return sysmanagerDao.updateSysmanagerById(enti);
    }

    //登录方法
    @Override
    public Sysmanager SysManagerLogin(String smusername, String smpassword) {
        return sysmanagerDao.SysManagerLogin(smusername,smpassword);
    }

    public SysmanagerDao getSysmanagerDao() {
        return this.sysmanagerDao;
    }

    public void setSysmanagerDao(SysmanagerDao sysmanagerDao) {
        this.sysmanagerDao = sysmanagerDao;
    }

}