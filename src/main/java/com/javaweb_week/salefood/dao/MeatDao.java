package com.javaweb_week.salefood.dao;
import com.javaweb_week.salefood.entity.Meat;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MeatDao{
    long getMeatRowCount();
    List<Meat> selectMeat();
    Meat selectMeatById(Integer id);
    int insertMeat(Meat value);
    int deleteMeatById(Integer id);
    int updateMeatById(Meat enti);

}