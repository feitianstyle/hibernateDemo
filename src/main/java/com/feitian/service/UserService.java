package com.feitian.service;

import com.feitian.dao.UserDao;
import com.feitian.utils.HibernateUtil;
import com.feitian.pojo.User;
import org.hibernate.Transaction;
import java.io.Serializable;

/**
 * @Author: feitian
 * @Date: 2018-04-16  17:27
 * @description:
 */
public class UserService {

    public void updateUser(User user){
        Transaction tx = null;

        try {
            tx = HibernateUtil.getCurrentSession().beginTransaction();

            User u = new UserDao().load(user.getId());
            u.setName(user.getName());
            u.setSex(user.getSex());

            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            if (tx!=null){
                tx.rollback();
            }
        }
    }

    public void addUser(User user){
        Transaction tx = null;

        try {
           tx = HibernateUtil.getCurrentSession().beginTransaction();

           new UserDao().save(user);

           tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            if (tx!=null){
                tx.rollback();
            }
        }
    }
    public User getUser2Get(Serializable id){
        Transaction tx = null;
        User user = null;

        try {
            tx = HibernateUtil.getCurrentSession().beginTransaction();
            user = new UserDao().get(id);
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            if (tx!=null){
                tx.rollback();
            }
        }
        return user;
    }
    public User getUesr2Load(Serializable id){
        User user = null ;
        Transaction tx = null;
        try {
            tx = HibernateUtil.getCurrentSession().beginTransaction();
            user = new UserDao().load(id);
            System.out.println("user name : " + user.getName());
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            if (tx!=null){
                tx.rollback();
            }
        }
        return user ;
    }
    public void update(User user){
        Transaction tx = null;
        try {
            tx = HibernateUtil.getCurrentSession().beginTransaction();
            new UserDao().update(user);
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            if (tx!=null){
                tx.rollback();
            }
        }
    }

    public void merge(User user){
        Transaction tx = null;
        try {
            tx = HibernateUtil.getCurrentSession().beginTransaction();
            new UserDao().merge(user);
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            if (tx!=null){
                tx.rollback();
            }
        }
    }

    public void deleteUser(Serializable id){
        Transaction tx = null;
        try {
            tx = HibernateUtil.getCurrentSession().beginTransaction();
            new UserDao().deleteUser(id);
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            if (tx!=null){
                tx.rollback();
            }
        }
    }
    public void deleteUser(User user){
        Transaction tx = null;
        try {
            tx = HibernateUtil.getCurrentSession().beginTransaction();
            new UserDao().deleteUser_2(user);
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            if (tx!=null){
                tx.rollback();
            }
        }
    }
}