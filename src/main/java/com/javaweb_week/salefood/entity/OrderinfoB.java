package com.javaweb_week.salefood.entity;
public class OrderinfoB {
    private Integer mid;
    private String oid;
    private Integer onum;
    private Integer opingf;
    public OrderinfoB() {
        super();
    }
    public OrderinfoB(Integer mid,String oid,Integer onum,Integer opingf) {
        super();
        this.mid = mid;
        this.oid = oid;
        this.onum = onum;
        this.opingf = opingf;
    }
    public Integer getMid() {
        return this.mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getOid() {
        return this.oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Integer getOnum() {
        return this.onum;
    }

    public void setOnum(Integer onum) {
        this.onum = onum;
    }

    public Integer getOpingf() {
        return this.opingf;
    }

    public void setOpingf(Integer opingf) {
        this.opingf = opingf;
    }

}
