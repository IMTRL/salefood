package com.javaweb_week.salefood.service.impl;
import java.util.List;
import com.javaweb_week.salefood.dao.OrdersBDao;
import com.javaweb_week.salefood.entity.OrdersB;
import com.javaweb_week.salefood.service.OrdersBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersBServiceImpl implements OrdersBService{
    @Autowired
    private OrdersBDao ordersBDao;
    @Override
    public long getOrdersBRowCount(){
        return ordersBDao.getOrdersBRowCount();
    }
    @Override
    public List<OrdersB> selectOrdersB(){
        return ordersBDao.selectOrdersB();
    }
    @Override
    public OrdersB selectOrdersBById(String id){
        return ordersBDao.selectOrdersBById(id);
    }
    @Override
    public int insertOrdersB(OrdersB value){
        return ordersBDao.insertOrdersB(value);
    }
    @Override
    public int deleteOrdersBById(String id){
        return ordersBDao.deleteOrdersBById(id);
    }
    @Override
    public int updateOrdersBById(OrdersB enti){
        return ordersBDao.updateOrdersBById(enti);
    }

    public OrdersBDao getOrdersBDao() {
        return this.ordersBDao;
    }

    public void setOrdersBDao(OrdersBDao ordersBDao) {
        this.ordersBDao = ordersBDao;
    }

}