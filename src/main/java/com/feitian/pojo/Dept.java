package com.feitian.pojo;

import java.util.Set;

/**
 * @Author: feitian
 * @Date: 2018-04-19  19:07
 * @description:
 */
public class Dept {
    private Integer deptNo;
    private String name;
    private String address;
    private Set<User> users;

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Dept() {
    }

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}