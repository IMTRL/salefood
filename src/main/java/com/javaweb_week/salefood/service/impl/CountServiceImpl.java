package com.javaweb_week.salefood.service.impl;

import com.javaweb_week.salefood.dao.CountDao;
import com.javaweb_week.salefood.entity.Count;
import com.javaweb_week.salefood.entity.Foods;
import com.javaweb_week.salefood.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountServiceImpl implements CountService {
    @Autowired
    private CountDao countDao;

    @Override
    public List<Count> selectCount() {
        return countDao.selectCount();
    }

    @Override
    public Count selectCountbyName(String mname, Integer oyear, Integer omonth, Integer oday) {
        return countDao.selectCountbyName(mname,oyear,omonth,oday);
    }


}
