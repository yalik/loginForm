package com.epam.dao;

import com.epam.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Konstantin Yalovik on 06.02.2017.
 */
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public User getUser(String username) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        User retrievedUser = (User) session.createCriteria(User.class).
                add(Restrictions.eq("username", username)).uniqueResult();
        session.getTransaction().commit();
        return retrievedUser;
    }

    public List<User> list() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<User> userList = session.createCriteria(User.class).list();
        session.getTransaction().commit();
        return userList;
    }
}
