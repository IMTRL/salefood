package com.javaweb_week.salefood.dao;
import com.javaweb_week.salefood.entity.OrderinfoB;
import java.util.List;
public interface OrderinfoBDao{
    long getOrderinfoBRowCount();
    List<OrderinfoB> selectOrderinfoB();
    OrderinfoB selectOrderinfoBById(Integer id);
    int insertOrderinfoB(OrderinfoB value);

    int deleteOrderinfoBById(Integer id);
    int updateOrderinfoBById(OrderinfoB enti);

}