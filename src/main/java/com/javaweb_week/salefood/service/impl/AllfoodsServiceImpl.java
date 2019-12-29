package com.javaweb_week.salefood.service.impl;
import java.util.List;
import com.javaweb_week.salefood.dao.AllfoodsDao;
import com.javaweb_week.salefood.entity.Allfoods;
import com.javaweb_week.salefood.service.AllfoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AllfoodsServiceImpl implements AllfoodsService{
    @Autowired
    private AllfoodsDao allfoodsDao;
    @Override
    public long getAllfoodsRowCount(){
        return allfoodsDao.getAllfoodsRowCount();
    }
    @Override
    public List<Allfoods> selectAllfoods(){
        return allfoodsDao.selectAllfoods();
    }
    @Override
    public Allfoods selectAllfoodsById(Integer id){
        return allfoodsDao.selectAllfoodsById(id);
    }
    @Override
    public int insertAllfoods(Allfoods value){
        return allfoodsDao.insertAllfoods(value);
    }

    @Override
    public int deleteAllfoodsById(Integer id){
        return allfoodsDao.deleteAllfoodsById(id);
    }
    @Override
    public int updateAllfoodsById(Allfoods enti){
        return allfoodsDao.updateAllfoodsById(enti);
    }


    public AllfoodsDao getAllfoodsDao() {
        return this.allfoodsDao;
    }

    public void setAllfoodsDao(AllfoodsDao allfoodsDao) {
        this.allfoodsDao = allfoodsDao;
    }

}