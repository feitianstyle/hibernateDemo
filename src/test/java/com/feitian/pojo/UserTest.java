package com.feitian.pojo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;



/**
 * @Author: feitian
 * @Date: 2018-04-16  16:12
 * @description:
 */
public class UserTest {
    @Test
    public void testSave(){
        Configuration conf = null;
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            conf =new Configuration().configure();
            sessionFactory = conf.buildSessionFactory();
            session = sessionFactory.getCurrentSession();//推荐使用，方便知道当前用户，会自动关闭
//            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            User user = new User();
            user.setId(10);
            user.setName("胡天霸");
            user.setSex("male");
            session.save(user);
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            if (tx !=null){
                tx.rollback();
            }
        }

    }

}