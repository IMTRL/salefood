package com.javaweb_week.salefood.dao;
import com.javaweb_week.salefood.entity.Rstmanager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RstmanagerDao{
    long getRstmanagerRowCount();
    List<Rstmanager> selectRstmanager();
    Rstmanager selectRstmanagerById(Integer id);
    int insertRstmanager(Rstmanager value);
    int deleteRstmanagerById(Integer id);
    int updateRstmanagerById(Rstmanager enti);

    //登录方法
    Rstmanager RstManagerLogin(@Param("rmusername") String rmusername, @Param("rmpassword") String rmpassword);
}