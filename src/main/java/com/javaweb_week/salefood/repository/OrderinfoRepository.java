package com.javaweb_week.salefood.repository;


import com.javaweb_week.salefood.entity.Orderinfo;
import com.javaweb_week.salefood.entity.OrderinfoMultiKeysClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderinfoRepository extends JpaRepository<Orderinfo, OrderinfoMultiKeysClass> {
    List<Orderinfo>findOrderinfoByOid(String oid);
}
