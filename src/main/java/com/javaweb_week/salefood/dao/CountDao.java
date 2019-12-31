package com.javaweb_week.salefood.dao;

import com.javaweb_week.salefood.entity.*;

import java.util.List;

public interface CountDao {
    List<Count> selectCount();

    Count selectCountbyName(String mname, Integer oyear, Integer omonth, Integer oday);
}
