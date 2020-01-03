package com.javaweb_week.salefood.entity;
public class StudentB {
    private Integer sid;
    private String sname;
    private String spassword;
    private Double sbalance;
    public StudentB() {
        super();
    }
    public StudentB(Integer sid,String sname,String spassword,Double sbalance) {
        super();
        this.sid = sid;
        this.sname = sname;
        this.spassword = spassword;
        this.sbalance = sbalance;
    }
    public Integer getSid() {
        return this.sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return this.sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSpassword() {
        return this.spassword;
    }

    public void setSpassword(String spassword) {
        this.spassword = spassword;
    }

    public Double getSbalance() {
        return this.sbalance;
    }

    public void setSbalance(Double sbalance) {
        this.sbalance = sbalance;
    }

}
