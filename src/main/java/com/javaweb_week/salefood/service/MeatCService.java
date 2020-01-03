package com.javaweb_week.salefood.service;
import java.util.List;
import com.javaweb_week.salefood.entity.MeatC;
public interface MeatCService{
    long getMeatCRowCount();
    List<MeatC> selectMeatC();
    MeatC selectMeatCById(Integer id);
    int insertMeatC(MeatC value);

    int deleteMeatCById(Integer id);
    int updateMeatCById(MeatC enti);
    List<MeatC> selectMeatCByName(String mname);

}