package com.feitian.service;

import com.feitian.pojo.Dept;
import com.feitian.pojo.User;
import org.junit.Test;

import java.io.Serializable;
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
}