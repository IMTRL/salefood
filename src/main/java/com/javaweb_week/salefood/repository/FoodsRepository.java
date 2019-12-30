package com.javaweb_week.salefood.repository;

import com.javaweb_week.salefood.entity.FoodsB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodsRepository extends JpaRepository<FoodsB,Integer> {
    List<FoodsB>findFoodsBByFid(int fid);

}
