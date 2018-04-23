package com.feitian.service;

import com.feitian.pojo.Dept;
import com.feitian.pojo.User;
import com.feitian.utils.HibernateUtil;
import org.hibernate.HibernateError;
import org.hibernate.Transaction;

import java.util.List;

/**
 * @Author: feitian
 * @Date: 2018-04-20  16:44
 * @description:
 */
public class TestHQLJoin {

    //左外连接
    public void testLeftJoin(){
        Transaction tx = null;
        try {
            tx = HibernateUtil.getCurrentSession().beginTransaction();

            String hql = "from Dept d left join d.users";
            //得出的集合里面是一个数组类型，一个数组为一个dept 和 user
            //内连接 右外连接一样的结果集
            List<Object[]> obj = HibernateUtil.getCurrentSession().createQuery(hql).list();
            for (Object[] ob:obj) {
                System.out.println(((Dept)ob[0]).getName() + " " + ((Dept)ob[0]).getDeptNo());
                System.out.println(" " +((User)ob[1]).getName());
            }
            tx.commit();
        }catch (HibernateError error){
            error.printStackTrace();
            if (tx!=null){
                tx.rollback();
            }
        }
    }

    /**
     * 迫切左外连接
     */
    public void testLeftJoinFetch(){
        Transaction tx = null;
        try {
            tx = HibernateUtil.getCurrentSession().beginTransaction();

            String hql = "from Dept d left join fetch d.users";
            //迫切左外连接 连接后 ，user对象自动填充到dept对象的set属性中，得到的结果是dept对象的集合
            List<Dept> obj = HibernateUtil.getCurrentSession().createQuery(hql).list();
            for (Dept ob:obj) {
                System.out.println(ob.getName());
            }
            tx.commit();
        }catch (HibernateError error){
            error.printStackTrace();
            if (tx!=null){
                tx.rollback();
            }
        }
    }

    public void testJoin(){
        Transaction tx = null;
        try {
            tx = HibernateUtil.getCurrentSession().beginTransaction();

            String hql = " from Dept d ,User u where d=u.dept ";

            List<Object[]> obj = HibernateUtil.getCurrentSession().createQuery(hql).list();
            for (Object[] ob:obj) {
                System.out.println(((Dept)ob[0]).getName());
                System.out.println(((User)ob[1]).getName());
            }
            tx.commit();
        }catch (HibernateError error){
            error.printStackTrace();
            if (tx!=null){
                tx.rollback();
            }
        }
    }

    /**
     * 隐式内连接
     *
     */
    public void testImplicitJoin(){
        Transaction tx = null;
        try {
            tx = HibernateUtil.getCurrentSession().beginTransaction();

//            String hql = " select name,address,dept.name from User ";
//            List<Object[]> objects = HibernateUtil.getCurrentSession().createQuery(hql).list();
//            for (Object[] ob:objects) {
//                System.out.println(ob[0]);
//                System.out.println(ob[1]);
//                System.out.println(ob[2]);
//            }
            String hql = "from User u where u.dept.deptNo = 1 ";
            List<User> obj = HibernateUtil.getCurrentSession().createQuery(hql).list();
            for (User ob:obj) {
                System.out.println(ob.getName());
            }
            tx.commit();
        }catch (HibernateError error){
            error.printStackTrace();
            if (tx!=null){
                tx.rollback();
            }
        }
    }

    /**
     * 分组查询
     */
    public void testGourp(){
        Transaction tx = null;
        try {
            tx = HibernateUtil.getCurrentSession().beginTransaction();

            String hql = " select avg(u.salary),u.dept.name from User u group by u.dept.name";

            List<Object[]> obj = HibernateUtil.getCurrentSession().createQuery(hql).list();
            for (Object[] ob:obj) {
                System.out.println(ob[0] + " , name: " + ob[1]);
            }
            tx.commit();
        }catch (HibernateError error){
            error.printStackTrace();
            if (tx!=null){
                tx.rollback();
            }
        }
    }
}