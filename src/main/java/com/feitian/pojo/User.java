package com.feitian.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author: feitian
 * @Date: 2018-04-16  14:57
 * @description:
 */
@Entity
@Table(name="user")//默认表名与类名一致
public class User implements Serializable {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "seq_name") //增长方式
    //@SequenceGenerator(name="seq_name",sequenceName = "user_seq",initialValue = 1,allocationSize = 10)
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="sex")
    private String sex;
    @Column(name="salary")
    private double salary;
    @Column(name="address")
    private String address;
    @Column(name="wife")
    private String wife;
    @Column(name="birthday")
    private Date birthday;
//    @Transient
    @ManyToOne(targetEntity = Dept.class,cascade = {CascadeType.MERGE},fetch = FetchType.LAZY)
    @JoinColumn(name = "deptNo")
    private Dept dept;

    public Dept getDept() {
        return dept;
    }
    public void setDept(Dept dept) {
        this.dept = dept;
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