package com.feitian.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @Author: feitian
 * @Date: 2018-04-17  23:05
 * @description:
 */
@Entity
public class Dept {
    private int id;
    private String name;
    private String address;
    private Integer deptNo;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "deptNo", nullable = true)
    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dept dept = (Dept) o;
        return id == dept.id &&
                Objects.equals(name, dept.name) &&
                Objects.equals(address, dept.address) &&
                Objects.equals(deptNo, dept.deptNo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, address, deptNo);
    }
}