package com.javaweb_week.salefood.dao;
import com.javaweb_week.salefood.entity.OrdersB;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrdersBDao{
    long getOrdersBRowCount();
    List<OrdersB> selectOrdersB();
    OrdersB selectOrdersBById(String id);
    int insertOrdersB(OrdersB value);
    int deleteOrdersBById(String id);
    int updateOrdersBById(OrdersB enti);
}