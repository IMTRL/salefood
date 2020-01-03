package com.javaweb_week.salefood.entity;
public class Rstmanager {
    private Integer rmid;
    private String rmrealname;
    private String rmusername;
    private String rmpassword;
    private Integer rmphone;
    public Rstmanager() {
        super();
    }
    public Rstmanager(Integer rmid,String rmrealname,String rmusername,String rmpassword,Integer rmphone) {
        super();
        this.rmid = rmid;
        this.rmrealname=rmrealname;
        this.rmusername = rmusername;
        this.rmpassword = rmpassword;
        this.rmphone = rmphone;
    }
    public Integer getRmid() {
        return this.rmid;
    }

    public void setRmid(Integer rmid) {
        this.rmid = rmid;
    }


    public String getRmrealname() {
        return this.rmrealname;
    }

    public void setRmrealname(String rmrealname) {
        this.rmrealname = rmrealname;
    }


    public String getRmusername() {
        return this.rmusername;
    }

    public void setRmusername(String rmusername) {
        this.rmusername = rmusername;
    }


    public String getRmpassword() {
        return this.rmpassword;
    }

    public void setRmpassword(String rmpassword) {
        this.rmpassword = rmpassword;
    }


    public Integer getRmphone() {
        return this.rmphone;
    }

    public void setRmphone(Integer rmphone) {
        this.rmphone = rmphone;
    }

}
