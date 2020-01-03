package com.javaweb_week.salefood.service.impl;
import java.util.List;
import com.javaweb_week.salefood.dao.OrderinfoBDao;
import com.javaweb_week.salefood.entity.OrderinfoB;
import com.javaweb_week.salefood.service.OrderinfoBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderinfoBServiceImpl implements OrderinfoBService{
    @Autowired
    private OrderinfoBDao orderinfoBDao;
    @Override
    public long getOrderinfoBRowCount(){
        return orderinfoBDao.getOrderinfoBRowCount();
    }
    @Override
    public List<OrderinfoB> selectOrderinfoB(){
        return orderinfoBDao.selectOrderinfoB();
    }
    @Override
    public OrderinfoB selectOrderinfoBById(Integer id){
        return orderinfoBDao.selectOrderinfoBById(id);
    }
    @Override
    public int insertOrderinfoB(OrderinfoB value){
        return orderinfoBDao.insertOrderinfoB(value);
    }

    @Override
    public int deleteOrderinfoBById(Integer id){
        return orderinfoBDao.deleteOrderinfoBById(id);
    }
    @Override
    public int updateOrderinfoBById(OrderinfoB enti){
        return orderinfoBDao.updateOrderinfoBById(enti);
    }

    public OrderinfoBDao getOrderinfoBDao() {
        return this.orderinfoBDao;
    }

    public void setOrderinfoBDao(OrderinfoBDao orderinfoBDao) {
        this.orderinfoBDao = orderinfoBDao;
    }

}