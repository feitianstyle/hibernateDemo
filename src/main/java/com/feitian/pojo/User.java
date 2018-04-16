package com.feitian.pojo;

import java.io.Serializable;

/**
 * @Author: feitian
 * @Date: 2018-04-16  14:57
 * @description:
 */
public class User implements Serializable {
    private int id;
    private String name;
    private String sex;

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
}