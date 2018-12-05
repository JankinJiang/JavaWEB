package Dao.impl;

import Dao.UserEntityDao;
import Entity.UserEntity;
import Utils.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserEntityDaoimpl implements UserEntityDao {
    @Override
    public UserEntity getByid(int id) {
        UserEntity user = new UserEntity();
        Session session = HibernateSessionFactory.getSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createQuery("from UserEntity where  id=" + id);
            user = (UserEntity)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }

    @Override
    public UserEntity getByname(String name) {
        UserEntity user = new UserEntity();
        Session session = HibernateSessionFactory.getSession();
        Transaction tx = session.beginTransaction();
        try {
            System.out.println("getByname");
            Query query = session.createQuery("from UserEntity where name='" + name+"'");
            user = (UserEntity)query.uniqueResult();
            System.out.println(user.getName()+" "+user.getPhone()+" "+user.getSex());
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }

    @Override
    public List<UserEntity> getBysex(String sex) {
        List<UserEntity> list = null;
        Session session = HibernateSessionFactory.getSession();
        Transaction tx = session.beginTransaction();
        try{
            System.out.println("getBysex");
            Query query = session.createQuery("from UserEntity where sex='"+sex+"'");
            list = query.list();
            tx.commit();
        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return list;
    }

    @Override
    public UserEntity getByphone(String phone) {
        UserEntity user = new UserEntity();
        Session session = HibernateSessionFactory.getSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createQuery("from UserEntity where  phone='" + phone+"'");
            user = (UserEntity)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }

    @Override
    public boolean addUser(UserEntity user) {
        Session session = HibernateSessionFactory.getSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(user);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            session.close();
            return false;
        }
    }

    @Override
    public boolean delUserByid(int id) {
        Session session = HibernateSessionFactory.getSession();
        Transaction tx = session.beginTransaction();
        try {
            UserEntity user = getByid(id);
            session.delete(user);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            session.close();
            return false;
        }
    }

    @Override
    public boolean updateUser(UserEntity user) {
        Session session = HibernateSessionFactory.getSession();
        Transaction tx = session.beginTransaction();
        try {
            UserEntity userEntity = (UserEntity) session.get(UserEntity.class, user.getId());
            userEntity.setSex(user.getSex());
            userEntity.setName(user.getName());
            userEntity.setPhone(user.getPhone());
            userEntity.setIdentity(user.getIdentity());
            session.update(userEntity);
            tx.commit();
            session.close();
            return true;
        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
            session.close();
            return false;
        }
    }
}
