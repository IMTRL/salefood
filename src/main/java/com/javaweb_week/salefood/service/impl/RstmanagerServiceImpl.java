package com.javaweb_week.salefood.service.impl;
import java.util.List;
import com.javaweb_week.salefood.dao.RstmanagerDao;
import com.javaweb_week.salefood.entity.Rstmanager;
import com.javaweb_week.salefood.service.RstmanagerService;
public class RstmanagerServiceImpl implements RstmanagerService{
    private RstmanagerDao rstmanagerDao;
    @Override
    public long getRstmanagerRowCount(){
        return rstmanagerDao.getRstmanagerRowCount();
    }
    @Override
    public List<Rstmanager> selectRstmanager(){
        return rstmanagerDao.selectRstmanager();
    }
    @Override
    public Rstmanager selectRstmanagerById(Integer id){
        return rstmanagerDao.selectRstmanagerById(id);
    }
    @Override
    public int insertRstmanager(Rstmanager value){
        return rstmanagerDao.insertRstmanager(value);
    }

    @Override
    public int deleteRstmanagerById(Integer id){
        return rstmanagerDao.deleteRstmanagerById(id);
    }
    @Override
    public int updateRstmanagerById(Rstmanager enti){
        return rstmanagerDao.updateRstmanagerById(enti);
    }

    public RstmanagerDao getRstmanagerDao() {
        return this.rstmanagerDao;
    }

    public void setRstmanagerDao(RstmanagerDao rstmanagerDao) {
        this.rstmanagerDao = rstmanagerDao;
    }

}