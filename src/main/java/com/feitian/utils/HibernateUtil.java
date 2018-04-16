package com.feitian.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @Author: feitian
 * @Date: 2018-04-16  17:16
 * @description:
 */
public class HibernateUtil {
    private static Configuration conf;
    private final static SessionFactory sessionFactory ;

    static {
        try {
            conf =new Configuration().configure();
            sessionFactory = conf.buildSessionFactory();
        }catch (Exception e){
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    }

    private HibernateUtil() {
    }

    public static Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }
}