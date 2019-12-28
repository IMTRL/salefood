package com.javaweb_week.salefood.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Service
@Entity
@Table(name = "Student")
public class Student {
    @Id
    private Integer sid;
    @Column
    private String sname;
    @Value("0000")
    @Column
    private String spassword;
    @Column
    private Double sbalance;
    public Student() {
        super();
    }
    public Student(Integer sid,String sname,String spassword,Double sbalance) {
        super();
        this.sid = sid;
        this.sname = sname;
        this.spassword = spassword;
        this.sbalance = sbalance;
    }

    public Student(Integer sid, String sname, Double sbalance) {
        this.sid = sid;
        this.sname = sname;
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
