package com.javaweb_week.salefood.dao;
import com.javaweb_week.salefood.entity.Allfoods;
import java.util.List;
public interface AllfoodsDao{
    long getAllfoodsRowCount();
    List<Allfoods> selectAllfoods();
    Allfoods selectAllfoodsById(Integer id);
    int insertAllfoods(Allfoods value);
    int deleteAllfoodsById(Integer id);
    int updateAllfoodsById(Allfoods enti);

}