package com.javaweb_week.salefood.service;
import java.util.List;
import com.javaweb_week.salefood.entity.Allfoods;
public interface AllfoodsService{
    long getAllfoodsRowCount();
    List<Allfoods> selectAllfoods();
    Allfoods selectAllfoodsById(Integer id);
    int insertAllfoods(Allfoods value);
    int deleteAllfoodsById(Integer id);
    int updateAllfoodsById(Allfoods enti);

}