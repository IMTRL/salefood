package com.javaweb_week.salefood.service;
import java.util.List;
import com.javaweb_week.salefood.entity.Meat;
public interface MeatService{
    long getMeatRowCount();
    List<Meat> selectMeat();
    Meat selectMeatById(Integer id);
    int insertMeat(Meat value);
    int deleteMeatById(Integer id);
    int updateMeatById(Meat enti);
}