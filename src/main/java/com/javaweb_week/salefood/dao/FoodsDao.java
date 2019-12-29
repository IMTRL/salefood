package com.javaweb_week.salefood.dao;
import com.javaweb_week.salefood.entity.Foods;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface FoodsDao{
    long getFoodsRowCount();
    List<Foods> selectFoods();
    Foods selectFoodsById(Integer id);
    int insertFoods(Foods value);
    int deleteFoodsById(Integer id);
    int updateFoodsById(Foods enti);

}