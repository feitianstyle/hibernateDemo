package com.feitian.service;

import com.feitian.dao.DeptDao;
import com.feitian.pojo.Dept;
import com.feitian.pojo.User;
import com.feitian.utils.HibernateUtil;
import org.hibernate.Transaction;

import java.io.Serializable;

/**
 * @Author: feitian
 * @Date: 2018-04-18  9:33
 * @description:
 */
public class DeptService {
    private DeptDao deptDao = new DeptDao();

    public Dept getDeptById(Serializable id){
        Transaction tx = null ;
        Dept dept = null;
        try{
            tx = HibernateUtil.getCurrentSession().beginTransaction();
            dept = deptDao.getDeptById(id);
        }catch (Exception e){
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        }
        return dept;
    }

    public void save(Dept dept){
        Transaction tx = null ;
        try{
            tx = HibernateUtil.getCurrentSession().beginTransaction();
            deptDao.saveByDept(dept);
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    public void updateDept(Dept dept){
        Transaction tx = null ;
        try{
            tx = HibernateUtil.getCurrentSession().beginTransaction();
            deptDao.updateDept(dept);
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        }
    }

}