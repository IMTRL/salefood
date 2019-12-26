package com.javaweb_week.salefood.dao;
import com.javaweb_week.salefood.entity.Rstmanager;
import java.util.List;
public interface RstmanagerDao{
    long getRstmanagerRowCount();
    List<Rstmanager> selectRstmanager();
    Rstmanager selectRstmanagerById(Integer id);
    int insertRstmanager(Rstmanager value);
    int deleteRstmanagerById(Integer id);
    int updateRstmanagerById(Rstmanager enti);

}