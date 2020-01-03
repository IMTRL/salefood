package com.javaweb_week.salefood.service;
import java.util.List;
import com.javaweb_week.salefood.entity.OrderinfoB;
public interface OrderinfoBService{
    long getOrderinfoBRowCount();
    List<OrderinfoB> selectOrderinfoB();
    OrderinfoB selectOrderinfoBById(Integer id);
    int insertOrderinfoB(OrderinfoB value);

    int deleteOrderinfoBById(Integer id);
    int updateOrderinfoBById(OrderinfoB enti);

}