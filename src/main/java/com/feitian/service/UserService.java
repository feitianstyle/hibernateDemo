package com.feitian.service;

import com.feitian.dao.UserDao;
import com.feitian.utils.hibernateUtil;
import com.feitian.pojo.User;
import org.hibernate.Transaction;

/**
 * @Author: feitian
 * @Date: 2018-04-16  17:27
 * @description:
 */
public class UserService {
    public void addUser(User user){
        Transaction tx = null;

        try {
           tx = hibernateUtil.getCurrentSession().beginTransaction();

           new UserDao().save(user);

           tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            if (tx!=null){
                tx.rollback();
            }
        }
    }
}