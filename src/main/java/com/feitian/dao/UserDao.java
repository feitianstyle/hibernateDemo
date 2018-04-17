package com.feitian.dao;

import com.feitian.pojo.User;
import com.feitian.utils.HibernateUtil;

import java.io.Serializable;

/**
 * @Author: feitian
 * @Date: 2018-04-16  17:24
 * @description:
 */
public class UserDao {
    public void save(User user){
        HibernateUtil.getCurrentSession().save(user);
    }
    public User get(Serializable id){
        return HibernateUtil.getCurrentSession().get(User.class,id);
    }
    public User load(Serializable id){
        return HibernateUtil.getCurrentSession().load(User.class,id);
    }
    public void update(User user){
        HibernateUtil.getCurrentSession().update(user);
    }
    public void merge(User user){
        HibernateUtil.getCurrentSession().merge(user);
    }
    public void deleteUser(Serializable id){
        User user = load(id);
        HibernateUtil.getCurrentSession().delete(user);
    }
    public void deleteUser_2(User user){
        HibernateUtil.getCurrentSession().delete(user);
    }
}