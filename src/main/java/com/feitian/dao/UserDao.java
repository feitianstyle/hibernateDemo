package com.feitian.dao;

import com.feitian.pojo.User;
import com.feitian.utils.hibernateUtil;

/**
 * @Author: feitian
 * @Date: 2018-04-16  17:24
 * @description:
 */
public class UserDao {
    public void save(User user){
        hibernateUtil.getCurrentSession().save(user);
    }
}