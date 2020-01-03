package com.javaweb_week.salefood.entity;
public class Sysmanager {
    private Integer smid;
    private String smrealname;
    private String smusername;
    private String smpassword;
    private Integer smphone;
    public Sysmanager() {
        super();
    }
    public Sysmanager(Integer smid,String smrealname,String smusername,String smpassword,Integer smphone) {
        super();
        this.smid = smid;
        this.smrealname = smrealname;
        this.smusername = smusername;
        this.smpassword = smpassword;
        this.smphone = smphone;
    }
    public Integer getSmid() {
        return this.smid;
    }

    public void setSmid(Integer smid) {
        this.smid = smid;
    }

    public String getSmrealname() {
        return this.smrealname;
    }

    public void setSmrealname(String smrealname) {
        this.smrealname = smrealname;
    }

    public String getSmusername() {
        return this.smusername;
    }

    public void setSmusername(String smusername) {
        this.smusername = smusername;
    }

    public String getSmpassword() {
        return this.smpassword;
    }

    public void setSmpassword(String smpassword) {
        this.smpassword = smpassword;
    }

    public Integer getSmphone() {
        return this.smphone;
    }

    public void setSmphone(Integer smphone) {
        this.smphone = smphone;
    }

}
