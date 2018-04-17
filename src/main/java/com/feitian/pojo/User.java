package com.feitian.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: feitian
 * @Date: 2018-04-16  14:57
 * @description:
 */
public class User implements Serializable {
    private int id;
    private String name;
    private String sex;
    private double salary;
    private String address;
    private String wife;
    private Date birthday;
    private Dept deptNo;

    public Dept getDeptNo() {
        return deptNo;
    }
    public void setDeptNo(Dept deptNo) {
        this.deptNo = deptNo;
    }
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getBrithday() {
        return birthday;
    }

    public void setBrithday(Date brithday) {
        this.birthday = brithday;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWife() {
        return wife;
    }

    public void setWife(String wife) {
        this.wife = wife;
    }
}