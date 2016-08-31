package com.goit.gojavaonline.model.dao.hibernate;

import com.goit.gojavaonline.model.Order;
import com.goit.gojavaonline.model.dao.OrderDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by tamila on 8/30/16.
 */
public class HOrderDao implements OrderDao{
    private SessionFactory sessionFactory;

    @Override
    public void save(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }

    @Override
    public void insertDishInOrder(int orderId, int dishId) {

    }

    @Override
    public void deleteDishFromOrder(int orderId, int dishId) {

    }

    @Override
    public void deleteOrder(int id) {

    }

    @Override
    public void closeOrder(int id) {

    }

    @Override
    public List<Order> getOrders(boolean closed) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select o from Order o").list();
    }

    @Override
    public Order getOrderById(int id) {
        Order result = sessionFactory.getCurrentSession().load(Order.class, id);
        if(result == null) {
            throw new RuntimeException("Cannot find Employee by id: "+ id);
        }
        return result;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
