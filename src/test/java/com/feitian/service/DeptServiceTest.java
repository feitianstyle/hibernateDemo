package com.feitian.service;

import com.feitian.pojo.Dept;
import com.feitian.pojo.User;
import com.feitian.utils.DateUtil;
import org.junit.Test;

import java.io.Serializable;
import java.util.Date;
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
        dept.setDeptNo(10);

        dept.setAddress("大英");
        dept.setName("市场部");
        User user = new User();
        user.setSalary(2000.0);
        user.setName("binghanhan");
        user.setDept(dept);
        Set<User> users = new HashSet<>();
        users.add(user);
        dept.setUsers(users);

        deptService.save(dept);

    }

    @Test
    public void updateDept() {
        Dept dept = new Dept();
        dept.setName("销售");
        dept.setAddress("上海");
        dept.setDeptNo(4);

        User user = new User();
        user.setName("胡杰全");
        user.setSalary(5000.0);
        user.setBrithday(DateUtil.strToDate("2018-04-20","yyyy-MM-dd"));
        user.setSex("man");
        user.setAddress("广安");
        user.setWife("武胜");
        HashSet<User> users = new HashSet<>();
        users.add(user);
        dept.setUsers(users);

        deptService.updateDept(dept);

    }
}