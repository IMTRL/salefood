package com.javaweb_week.salefood.service;
import java.util.List;
import com.javaweb_week.salefood.entity.Foods;
public interface FoodsService{
    long getFoodsRowCount();
    List<Foods> selectFoods();
    Foods selectFoodsById(Integer id);
    int insertFoods(Foods value);
    int deleteFoodsById(Integer id);
    int updateFoodsById(Foods enti);

}