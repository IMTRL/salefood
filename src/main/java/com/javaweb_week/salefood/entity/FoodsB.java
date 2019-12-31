package com.javaweb_week.salefood.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name = "foods")
public class FoodsB {
    private Integer fid;
    private String fname;
    private Integer fnum;
    public FoodsB() {
        super();
    }
    public FoodsB(Integer fid,Integer apk,String fname,Integer fnum) {
        super();
        this.fid = fid;
        this.fname = fname;
        this.fnum = fnum;
    }
    @Id
    public Integer getFid() {
        return this.fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    @Column
    public String getFname() {
        return this.fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }
    @Column
    public Integer getFnum() {
        return this.fnum;
    }

    public void setFnum(Integer fnum) {
        this.fnum = fnum;
    }
}
