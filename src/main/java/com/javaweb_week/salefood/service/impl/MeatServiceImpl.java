package com.javaweb_week.salefood.service.impl;
import java.util.List;
import com.javaweb_week.salefood.dao.MeatDao;
import com.javaweb_week.salefood.entity.Meat;
import com.javaweb_week.salefood.service.MeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeatServiceImpl implements MeatService{
    @Autowired
    private MeatDao meatDao;

    @Override
    public long getMeatRowCount() {
        return 0;
    }

    @Override
    public List<Meat> selectMeat(Integer Fid){
        return meatDao.selectMeat(Fid);
    }
    @Override
    public Meat selectMeatById(Integer id){
        return meatDao.selectMeatById(id);
    }
    @Override
    public int insertMeat(Meat value){
        return meatDao.insertMeat(value);
    }

    @Override
    public int deleteMeatById(Integer id){
        return meatDao.deleteMeatById(id);
    }
    @Override
    public int updateMeatById(Meat enti){
        return meatDao.updateMeatById(enti);
    }


    public MeatDao getMeatDao() {
        return this.meatDao;
    }

    public void setMeatDao(MeatDao meatDao) {
        this.meatDao = meatDao;
    }

}