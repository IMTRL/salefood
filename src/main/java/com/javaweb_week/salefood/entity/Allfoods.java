package com.javaweb_week.salefood.entity;
public class Allfoods {
    private Integer apk;
    private String aname;
    public Allfoods() {
        super();
    }
    public Allfoods(Integer apk,String aname) {
        super();
        this.apk = apk;
        this.aname = aname;
    }
    public Integer getApk() {
        return this.apk;
    }

    public void setApk(Integer apk) {
        this.apk = apk;
    }

    public String getAname() {
        return this.aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

}
