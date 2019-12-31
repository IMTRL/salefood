package com.javaweb_week.salefood.entity;

import java.util.Date;

public class Count {
    private Integer mid;
    private String mname;
    private Integer onum;
    private Integer oyear;
    private Integer omonth;
    private Integer oday;
    public Count(){super(); }
    public Count(Integer mid,String mname,Integer oyear,Integer omonth,Integer oday)
    {
        super();
        this.mid=mid;
        this.mname=mname;
        this.oyear=oyear;
        this.omonth=omonth;
        this.oday=oday;
    }

    public Integer getMid() { return mid; }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public Integer getOyear() {
        return oyear;
    }

    public void setOyear(Integer oyear) {
        this.oyear = oyear;
    }

    public Integer getOmonth() {
        return omonth;
    }

    public void setOmonth(Integer omonth) {
        this.omonth = omonth;
    }

    public Integer getOday() {
        return oday;
    }

    public void setOday(Integer oday) {
        this.oday = oday;
    }

    public Integer getOnum() { return onum; }

    public void setOnum(Integer onum) { this.onum = onum; }
}
