package com.feitian.dao;

import com.feitian.pojo.User;
import com.feitian.utils.HibernateUtil;
import com.sun.org.apache.regexp.internal.REUtil;
import javafx.beans.binding.ObjectExpression;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

    /**
     * 直接更新
     * @param user
     */
    public void update(User user){
        HibernateUtil.getCurrentSession().update(user);
    }

    /**
     * 先查询，后合并更新
     * @param user
     */
    public void merge(User user){
        HibernateUtil.getCurrentSession().merge(user);
    }

    /**
     * 先查询，再删除
     * @param id
     */
    public void deleteUser(Serializable id){
        User user = load(id);
        HibernateUtil.getCurrentSession().delete(user);
    }

    /**
     * 直接删除
     * @param user
     */
    public void deleteUser_2(User user){
        HibernateUtil.getCurrentSession().delete(user);
    }

    /**
     * 先检查主键，若和数据库没有关联（没有设定主键或主键不存在），就直接save,若存在就直接update
     * @param user
     */
    public void saveOrUpdate(User user){
        HibernateUtil.getCurrentSession().saveOrUpdate(user);
    }

    /**
     * HQL查询，返回list
     * @return
     */
    public List<User> queryUser(){
        String hql = "from User";
        return HibernateUtil.getCurrentSession().createQuery(hql).list();
    }

    public Iterator<User> queryUser2Iterable(){
        String hql = "from User";
        return HibernateUtil.getCurrentSession().createQuery(hql).iterate();
    }

    public Long countUser(){
        String hql = "select count(name) from User";
        //返回单条结果 uniqueResult
        return (Long) HibernateUtil.getCurrentSession().createQuery(hql).uniqueResult();
    }

    public List<User> getUserByName(String name){
        return HibernateUtil.getCurrentSession().createQuery("from User where name = ?")
                .setParameter(0,name).list();
    }

    /**
     * 推荐使用这种使用名称的占位符
     * @param  sex
     * @return List<User>
     */
    public List<User> getUserBySex(String sex){
        return HibernateUtil.getCurrentSession().createQuery("from User where sex = :sex")
                .setParameter("sex",sex).list();
    }

    public List<User> getUserByUser(User user){
        Query query = HibernateUtil.getCurrentSession().createQuery("from User where name = :name or sex = :sex");
        query.setProperties(user);
        return query.list();
    }

    public List<User> findUserByHql(String hql,User user){
        Query query = HibernateUtil.getCurrentSession().createQuery(hql);
        query.setProperties(user);
        return query.list();
    }

    public List<User> findUserByMap(String hql, Map<String,Object> map){
        Query query = HibernateUtil.getCurrentSession().createQuery(hql);
        query.setProperties(map);
        return query.list();
    }

    /**
     * 分页查询
     * @param pageNo
     * @param pageSize
     * @return
     */
    public List<User> findUserByPage(int pageNo,int pageSize){
        return  HibernateUtil.getCurrentSession().createQuery("from User order by salary desc")
                .setFirstResult((pageNo-1)*pageSize)
                .setMaxResults(pageSize)
                .list();
    }

    /**
     * 投影查询，如果查询为多个属性，返回的类型为List<Object[]>这种类型
     * @return
     */
    public List<Object> findColum(){
        return HibernateUtil.getCurrentSession().createQuery("select name from User")
                .list();
    }
}