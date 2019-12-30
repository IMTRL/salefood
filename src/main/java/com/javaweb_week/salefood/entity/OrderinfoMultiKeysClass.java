package com.javaweb_week.salefood.entity;

import java.io.Serializable;
import java.util.Objects;

public class OrderinfoMultiKeysClass implements Serializable {
    private Integer mid;
    private String oid;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderinfoMultiKeysClass)) return false;
        OrderinfoMultiKeysClass that = (OrderinfoMultiKeysClass) o;
        return Objects.equals(mid, that.mid) &&
                Objects.equals(oid, that.oid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mid, oid);
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public OrderinfoMultiKeysClass() {
    }

    public OrderinfoMultiKeysClass(Integer mid, String oid) {
        this.mid = mid;
        this.oid = oid;
    }
}
