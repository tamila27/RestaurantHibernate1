package com.goit.gojavaonline.model.dao.hibernate;

import com.goit.gojavaonline.model.Dish;
import com.goit.gojavaonline.model.dao.DishDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tamila on 8/30/16.
 */
public class HDishDao implements DishDao {
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(Dish dish) {
        sessionFactory.getCurrentSession().save(dish);
    }

    @Override
    @Transactional
    public List<Dish> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select d from Dish d").list();
    }

    @Override
    @Transactional
    public Dish findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select d from Dish d where d.name like :name");
        query.setParameter("name", name);
        return (Dish) query.uniqueResult();
    }

    @Override
    public void deleteDish(Dish dish) {
        sessionFactory.getCurrentSession().delete(dish);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
