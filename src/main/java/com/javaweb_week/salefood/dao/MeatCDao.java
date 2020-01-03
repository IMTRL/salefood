package com.javaweb_week.salefood.dao;
import com.javaweb_week.salefood.entity.MeatC;

import java.util.List;

public interface MeatCDao{
    long getMeatCRowCount();
    List<MeatC> selectMeatC();
    MeatC selectMeatCById(Integer id);
    int insertMeatC(MeatC value);

    int deleteMeatCById(Integer id);
    int updateMeatCById(MeatC enti);
    List<MeatC> selectMeatCByName(String mname);

}