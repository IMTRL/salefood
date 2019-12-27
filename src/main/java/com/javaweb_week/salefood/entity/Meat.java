package com.javaweb_week.salefood.entity;
public class Meat {
    private Integer mid;
    private Integer fid;
    private Integer meatid;
    private String mname;
    private String mstyle;
    private Double mprice;
    private String mpicture;
    public Meat() {
        super();
    }
    public Meat(Integer mid,Integer fid,Integer meatid,String mname,String mstyle,Double mprice,String mpicture) {
        super();
        this.mid = mid;
        this.fid = fid;
        this.meatid = meatid;
        this.mname = mname;
        this.mstyle = mstyle;
        this.mprice = mprice;
        this.mpicture = mpicture;
    }
    public Integer getMid() {
        return this.mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getFid() {
        return this.fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getMeatid() {
        return this.meatid;
    }

    public void setMeatid(Integer meatid) {
        this.meatid = meatid;
    }

    public String getMname() {
        return this.mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMstyle() {
        return this.mstyle;
    }

    public void setMstyle(String mstyle) {
        this.mstyle = mstyle;
    }

    public Double getMprice() {
        return this.mprice;
    }

    public void setMprice(Double mprice) {
        this.mprice = mprice;
    }

    public String getMpicture() {
        return this.mpicture;
    }

    public void setMpicture(String mpicture) {
        this.mpicture = mpicture;
    }

}
