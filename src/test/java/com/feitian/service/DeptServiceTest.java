package com.feitian.service;

import com.feitian.pojo.Dept;
import com.feitian.pojo.User;
import org.junit.Test;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @Author: feitian
 * @Date: 2018-04-18  9:36
 * @description:
 */
public class DeptServiceTest {
    private DeptService deptService = new DeptService();
    @Test
    public void getDeptById() {
        Serializable id = 1 ;
        Dept dept = deptService.getDeptById(id);
        Set<User> users = dept.getUsers();
        System.out.println("deptName : " + dept.getName());
        for (User user:users) {
            System.out.println(user.getName());
        }
    }


    @Test
    public void save() {
        Dept dept = new Dept();
        dept.setDeptNo(1);
        dept.setId(1);
        dept.setAddress("大英");
        dept.setName("市场部");
        User user = new User();
        user.setSalary(2000.0);
        user.setName("binghanhan");
        user.setDeptNo(dept);
        Set<User> users = new HashSet<>();
        users.add(user);
        dept.setUsers(users);

        deptService.save(dept);

    }
}