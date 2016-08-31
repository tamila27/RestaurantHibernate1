package com.goit.gojavaonline.model.dao.hibernate;

import com.goit.gojavaonline.model.PreparedDish;
import com.goit.gojavaonline.model.dao.PreparedDishDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by tamila on 8/31/16.
 */
public class HPreparedDishDao implements PreparedDishDao {
    private SessionFactory sessionFactory;

    @Override
    public void insertPreparedDish(PreparedDish preparedDish) {
        sessionFactory.getCurrentSession().save(preparedDish);
    }

    @Override
    public List<PreparedDish> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select i from PreparedDish i").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
