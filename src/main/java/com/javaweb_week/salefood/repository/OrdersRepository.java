package com.javaweb_week.salefood.repository;

import com.javaweb_week.salefood.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, String> {
    List<Orders> findOrdersBySid(int sid);

    List<Orders> findOrdersByOyearAndOmonthAndOday(int oyear, int omonth, int oday);
    List<Orders> findOrdersByOyearAndOmonth(int oyear, int omonth);

}
