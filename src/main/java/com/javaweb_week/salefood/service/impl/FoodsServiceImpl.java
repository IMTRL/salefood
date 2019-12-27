package com.javaweb_week.salefood.service.impl;
import java.util.List;
import com.javaweb_week.salefood.dao.FoodsDao;
import com.javaweb_week.salefood.entity.Foods;
import com.javaweb_week.salefood.service.FoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodsServiceImpl implements FoodsService{
    @Autowired
    private FoodsDao foodsDao;
    @Override
    public long getFoodsRowCount(){
        return foodsDao.getFoodsRowCount();
    }
    @Override
    public List<Foods> selectFoods(){
        return foodsDao.selectFoods();
    }
    @Override
    public Foods selectFoodsById(Integer id){
        return foodsDao.selectFoodsById(id);
    }
    @Override
    public int insertFoods(Foods value){
        return foodsDao.insertFoods(value);
    }

    @Override
    public int deleteFoodsById(Integer id){
        return foodsDao.deleteFoodsById(id);
    }
    @Override
    public int updateFoodsById(Foods enti){
        return foodsDao.updateFoodsById(enti);
    }


    public FoodsDao getFoodsDao() {
        return this.foodsDao;
    }

    public void setFoodsDao(FoodsDao foodsDao) {
        this.foodsDao = foodsDao;
    }

}