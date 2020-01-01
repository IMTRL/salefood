package com.javaweb_week.salefood.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name = "orderinfo")
@IdClass(OrderinfoMultiKeysClass.class)
public class Orderinfo {
    private Integer mid;
    private String oid;
    private Integer onum;
    private boolean opingf;



    public Orderinfo() {
        super();
    }

    public Orderinfo(Integer mid, String oid, Integer onum, boolean opingf) {
        this.mid = mid;
        this.oid = oid;
        this.onum = onum;
        this.opingf = opingf;
    }

    public Orderinfo(Integer mid, Integer onum, boolean opingf) {
        this.mid = mid;
        this.onum = onum;
        this.opingf = opingf;
    }

    @Id
    public Integer getMid() {
        return this.mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }
    @Id
    public String getOid() {
        return this.oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }
    @Column
    public Integer getOnum() {
        return this.onum;
    }

    public void setOnum(Integer onum) {
        this.onum = onum;
    }
    @Column
    public boolean getOpingf() {
        return opingf;
    }

    public void setOpingf(boolean opingf) {
        this.opingf = opingf;
    }

}
