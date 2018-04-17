package com.feitian.pojo;

import com.feitian.service.UserService;
import org.junit.Test;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;


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
    @Test
    public void testUpdateUser(){
        User user = new User();
        user.setId(1);
        user.setName("并韩寒");
        user.setSex("femal");
        new UserService().updateUser(user);
    }
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(1);
        user.setSex("man");
        user.setName("binghanhan");
        new UserService().update(user);
    }
    @Test
    public void testMerge(){
        User user = new User();
        user.setId(2);
        user.setSex("man");
        user.setName("binghanhan");
        new UserService().merge(user);
    }
    @Test
    public void testDeleteUser(){
        Serializable id = 6 ;
        new UserService().deleteUser(id);
    }
    @Test
    public void testDeleteUser_2(){
       User user = new User();
       user.setId(4);
       new UserService().deleteUser(user);
    }
    @Test
    public void testSaveOrUpdate(){
        User user = new User();
        user.setName("hanhan");
        new UserService().saveOrUpdate(user);
    }
    @Test
    public void testQueryUser(){
        List<User> users = new UserService().queryUser();
        for (User user:users) {
            System.out.println(user.getName());
        }
    }
    @Test
    public void testQuery2Iterable(){
        Iterator<User> users = new UserService().queryUser2Iterable();
    }
    @Test
    public void testCountUser(){
        System.out.println(new UserService().countUser());
    }
    @Test
    public void testGetUserByName(){
        String name = "胡杰双";
        List<User> users = new UserService().getUserByName(name);
        for (User user:users) {
            System.out.println(user.getSex() + " " + user.getName());
        }
    }
    @Test
    public void testGetUserBySex(){
        String sex = "man";
        List<User> users = new UserService().getUserBySex(sex);
        for (User user:users) {
            System.out.println(user.getName());
        }
    }
    @Test
    public void testGetUserByUser(){
        User user = new User();
        user.setName("binghanhan");
        user.setSex("man");
        List<User> users = new UserService().getUserByUser(user);
        for (User u:users) {
            System.out.println(u.getName());
        }
    }
}