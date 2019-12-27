package com.javaweb_week.salefood.dao;
import com.javaweb_week.salefood.entity.Foods;
import java.util.List;
public interface FoodsDao{
    long getFoodsRowCount();
    List<Foods> selectFoods();
    Foods selectFoodsById(Integer id);
    int insertFoods(Foods value);
    int insertNonEmptyFoods(Foods value);
    int deleteFoodsById(Integer id);
    int updateFoodsById(Foods enti);
    int updateNonEmptyFoodsById(Foods enti);
}