package com.javaweb_week.salefood.service.impl;
import java.util.List;
import com.javaweb_week.salefood.dao.MeatCDao;
import com.javaweb_week.salefood.entity.MeatC;
import com.javaweb_week.salefood.service.MeatCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeatCServiceImpl implements MeatCService{
    @Autowired
    private MeatCDao meatCDao;
    @Override
    public long getMeatCRowCount(){
        return meatCDao.getMeatCRowCount();
    }
    @Override
    public List<MeatC> selectMeatC(){
        return meatCDao.selectMeatC();
    }
    @Override
    public MeatC selectMeatCById(Integer id){
        return meatCDao.selectMeatCById(id);
    }
    @Override
    public int insertMeatC(MeatC value){
        return meatCDao.insertMeatC(value);
    }

    @Override
    public int deleteMeatCById(Integer id){
        return meatCDao.deleteMeatCById(id);
    }
    @Override
    public int updateMeatCById(MeatC enti){
        return meatCDao.updateMeatCById(enti);
    }

    @Override
    public List<MeatC> selectMeatCByName(String name){ return meatCDao.selectMeatCByName(name);}

    public MeatCDao getMeatCDao() {
        return this.meatCDao;
    }

    public void setMeatCDao(MeatCDao meatCDao) {
        this.meatCDao = meatCDao;
    }

}