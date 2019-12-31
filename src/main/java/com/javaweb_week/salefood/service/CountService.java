package com.javaweb_week.salefood.service;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.javaweb_week.salefood.entity.Count;
public interface CountService {

    List<Count> selectCount();

    Count selectCountbyName(String mname,Integer oyear,Integer omonth,Integer oday);
}
