package com.javaweb_week.salefood.service;
import java.util.List;
import com.javaweb_week.salefood.entity.OrdersB;
public interface OrdersBService{
    long getOrdersBRowCount();
    List<OrdersB> selectOrdersB();
    OrdersB selectOrdersBById(String id);
    int insertOrdersB(OrdersB value);
    int deleteOrdersBById(String id);
    int updateOrdersBById(OrdersB enti);
}