package com.feitian.dao;

import com.feitian.pojo.Dept;
import com.feitian.utils.HibernateUtil;

import javax.crypto.spec.DESedeKeySpec;
import java.io.Serializable;

/**
 * @Author: feitian
 * @Date: 2018-04-18  9:30
 * @description:
 */
public class DeptDao {
    /**
     * 多对一关系映射
     * @param id
     * @return
     */
    public Dept getDeptById(Serializable id){
        return HibernateUtil.getCurrentSession().get(Dept.class,id);
    }
    public void saveByDept(Dept dept){
        HibernateUtil.getCurrentSession().save(dept);
    }
    public void updateDept(Dept dept){
        HibernateUtil.getCurrentSession().save(dept);
    }
}