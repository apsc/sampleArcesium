package com.arcesium.model;

/**
 * Created by amanpsc on 12/11/15.
 */
public class Employee {
    private Integer eid, mid;
    private String name;
    public Employee(Integer id, String name, Integer mid) {
        this.eid = id;
        this.name = name;
        this.mid = mid;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
