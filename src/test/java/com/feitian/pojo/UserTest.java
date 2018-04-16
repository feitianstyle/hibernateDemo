package com.feitian.pojo;

import com.feitian.service.UserService;
import org.junit.Test;

import java.io.Serializable;


/**
 * @Author: feitian
 * @Date: 2018-04-16  16:12
 * @description:
 */
public class UserTest {
    @Test
    public void testSave(){
        User user = new User();
        user.setSex("femal");
        user.setName("王钢铁");
        new UserService().addUser(user);

    }
    @Test
    public void testGetUserByGet(){
        Serializable id = 1;
        User user = new UserService().getUser2Get(id);
        System.out.println("user name : " + user.getName());
    }
    @Test
    public void testGetUserByLoad(){
        Serializable id = 1;
        User user = new UserService().getUesr2Load(id);

    }
}