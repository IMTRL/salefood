package com.javaweb_week.salefood.entity;
public class OrdersB {
    private String oid;
    private Integer sid;
    private Double omoney;
    private Integer oyear;
    private Integer omonth;
    private Integer oday;
    public OrdersB() {
        super();
    }
    public OrdersB(String oid,Integer sid,Double omoney,Integer oyear,Integer omonth,Integer oday) {
        super();
        this.oid = oid;
        this.sid = sid;
        this.omoney = omoney;
        this.oyear = oyear;
        this.omonth = omonth;
        this.oday = oday;
    }
    public String getOid() {
        return this.oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Integer getSid() {
        return this.sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Double getOmoney() {
        return this.omoney;
    }

    public void setOmoney(Double omoney) {
        this.omoney = omoney;
    }

    public Integer getOyear() {
        return this.oyear;
    }

    public void setOyear(Integer oyear) {
        this.oyear = oyear;
    }

    public Integer getOmonth() {
        return this.omonth;
    }

    public void setOmonth(Integer omonth) {
        this.omonth = omonth;
    }

    public Integer getOday() {
        return this.oday;
    }

    public void setOday(Integer oday) {
        this.oday = oday;
    }

}
