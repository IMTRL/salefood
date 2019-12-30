package com.javaweb_week.salefood.repository;

import com.javaweb_week.salefood.entity.MeatB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeatRepository extends JpaRepository<MeatB,Integer> {
    List<MeatB>findMeatBByMid(int mid);
}
