package com.javaweb_week.salefood.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Entity
@Service
@Table(name = "student")
public class Student {

    private Integer sid;

    private String sname;

    private String spassword;

    private Double sbalance;

    public Student() {
        super();
    }

    public Student(Integer sid, String sname, String spassword, Double sbalance) {
        this.sid = sid;
        this.sname = sname;
        this.spassword = spassword;
        this.sbalance = sbalance;
    }

    @Id
    public Integer getSid() {
        return this.sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    @Column
    public String getSname() {
        return this.sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Column
    public String getSpassword() {
        return this.spassword;
    }

    public void setSpassword(String spassword) {
        this.spassword = spassword;
    }

    @Column
    public Double getSbalance() {
        return this.sbalance;
    }

    public void setSbalance(Double sbalance) {
        this.sbalance = sbalance;
    }

}
