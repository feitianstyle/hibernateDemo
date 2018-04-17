package com.feitian.service;

import com.feitian.dao.UserDao;
import com.feitian.utils.HibernateUtil;
import com.feitian.pojo.User;
import org.hibernate.Transaction;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Author: feitian
 * @Date: 2018-04-16  17:27
 * @description:
 */
public class UserService {
    private UserDao userDao = new UserDao();
    public void updateUser(User user) {
        Transaction tx = null;

        try {
            tx = HibernateUtil.getCurrentSession().beginTransaction();

            User u = userDao.load(user.getId());
            u.setName(user.getName());
            u.setSex(user.getSex());

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    public void addUser(User user) {
        Transaction tx = null;

        try {
            tx = HibernateUtil.getCurrentSession().beginTransaction();

            userDao.save(user);

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    public User getUser2Get(Serializable id) {
        Transaction tx = null;
        User user = null;

        try {
            tx = HibernateUtil.getCurrentSession().beginTransaction();
            user = userDao.get(id);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        }
        return user;
    }

    public User getUesr2Load(Serializable id) {
        User user = null;
        Transaction tx = null;
        try {
            tx = HibernateUtil.getCurrentSession().beginTransaction();
            user =userDao.load(id);
            System.out.println("user name : " + user.getName());
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        }
        return user;
    }

    public void update(User user) {
        Transaction tx = null;
        try {
            tx = HibernateUtil.getCurrentSession().beginTransaction();
            userDao.update(user);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    public void merge(User user) {
        Transaction tx = null;
        try {
            tx = HibernateUtil.getCurrentSession().beginTransaction();
            userDao.merge(user);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    public void deleteUser(Serializable id) {
        Transaction tx = null;
        try {
            tx = HibernateUtil.getCurrentSession().beginTransaction();
            userDao.deleteUser(id);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    public void deleteUser(User user) {
        Transaction tx = null;
        try {
            tx = HibernateUtil.getCurrentSession().beginTransaction();
            userDao.deleteUser_2(user);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    public void saveOrUpdate(User user) {
        Transaction tx = null;
        try {
            tx = HibernateUtil.getCurrentSession().beginTransaction();
            userDao.saveOrUpdate(user);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    public List<User> queryUser() {
        Transaction tx = null;
        List<User> users = null;
        try {
            tx = HibernateUtil.getCurrentSession().beginTransaction();
            users = userDao.queryUser();
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        }
        return users;
    }

    public Iterator<User> queryUser2Iterable() {
        Iterator iterable = null;
        Transaction tx = null;
        try {
            tx = HibernateUtil.getCurrentSession().beginTransaction();
            iterable = userDao.queryUser2Iterable();
            while (iterable.hasNext()) {
                User user = (User) iterable.next();
                System.out.println(user.getName());
            }
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        }
        return iterable;
    }

    public Long countUser() {
        Transaction tx = null;
        Long count = null;
        try {
            tx = HibernateUtil.getCurrentSession().beginTransaction();
            count = userDao.countUser();
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        }
        return count;
    }

    public List<User> getUserByName(String name) {
        Transaction tx = null;
        List<User> users = null;
        try {
            tx = HibernateUtil.getCurrentSession().beginTransaction();
            users = userDao.getUserByName(name);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        }
        return users;
    }

    public List<User> getUserBySex(String sex){
        Transaction tx = null;
        List<User> users = null;
        try {
            tx = HibernateUtil.getCurrentSession().beginTransaction();
            users = userDao.getUserBySex(sex);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        }
        return users;
    }

    public List<User> getUserByUser(User user){
        Transaction tx = null;
        List<User> users = null;
        try {
            tx = HibernateUtil.getCurrentSession().beginTransaction();
            users = userDao.getUserByUser(user);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        }
        return users;
    }

    public List<User>  findUserByHql(User user){
        Transaction tx = null;
        List<User> users = null;
        try {
            tx = HibernateUtil.getCurrentSession().beginTransaction();
            StringBuilder stringBuilder = new StringBuilder("from User where 1=1");
            if (user.getName()!=null && !user.getName().equals("")){
                stringBuilder.append(" and name = :name");
            }
            if (user.getSex()!=null&&!user.getSex().equals("")){
                stringBuilder.append(" and sex = :sex");
            }
            if(user.getBrithday()!=null&&user.getBrithday().equals("")){
                stringBuilder.append(" and birthday > :birthday");
            }
            if (user.getSalary() != 0){
                stringBuilder.append(" and salary > :salary ");
            }

            users = userDao.findUserByHql(stringBuilder.toString(),user);
            System.out.println(stringBuilder.toString());
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        }
        return users;
    }

    public List<User> findUserByMap(Map<String,Object> map){
        Transaction tx = null;
        List<User> users = null;
        try {
            tx = HibernateUtil.getCurrentSession().beginTransaction();
            StringBuilder stringBuilder = new StringBuilder("from User where 1=1 ");
            if (map.get("name")!=null){
                stringBuilder.append(" and name = :name");
            }
            if (map.get("sex")!=null){
                stringBuilder.append(" and sex = :sex");
            }
            if(map.get("birthday")!=null){
                stringBuilder.append(" and birthday > :birthday");
            }
            if (map.get("salary") != null){
                stringBuilder.append(" and salary > :salary ");
            }

            users = userDao.findUserByMap(stringBuilder.toString(),map);
            System.out.println(stringBuilder.toString());
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        }
        return users;
    }

    public List<User> findUserByPage(int pageNo,int pageSize){
        Transaction tx = null;
        List<User> users = null;
        try {
            tx = HibernateUtil.getCurrentSession().beginTransaction();
            users = userDao.findUserByPage(pageNo,pageSize);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        }
        return users;
    }

    public List<Object> findColum(){
        Transaction tx = null ;
        List<Object> ss = null ;
        try{
            tx = HibernateUtil.getCurrentSession().beginTransaction();
            ss = userDao.findColum();
        }catch (Exception e){
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        }
            return ss;
    }

    public User findUserByget(Serializable id){
        Transaction tx = null ;
        User user = null;
        try{
            tx = HibernateUtil.getCurrentSession().beginTransaction();
            user = userDao.findUserByget(id);
           //System.out.println(user.getName() + " " + user.getDeptNo().getName());
        }catch (Exception e){
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        }
        return user;
    }

}