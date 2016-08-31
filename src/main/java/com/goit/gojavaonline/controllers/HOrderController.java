package com.goit.gojavaonline.controllers;

import com.goit.gojavaonline.model.Dish;
import com.goit.gojavaonline.model.Order;
import com.goit.gojavaonline.model.dao.DishDao;
import com.goit.gojavaonline.model.dao.EmployeeDao;
import com.goit.gojavaonline.model.dao.OrderDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tamila on 8/30/16.
 */
public class HOrderController {
    private OrderDao orderDao;
    private EmployeeDao employeeDao;
    private DishDao dishDao;

    @Transactional
    public void createOrder(String waiterName, List<String> dishes, int tableNumber) {
        Order order = new Order();
        order.setEmployee(employeeDao.findByName(waiterName));
        order.setDishes(createDishes(dishes));
        order.setTableNum(tableNumber);
        order.setOrderDate("2016-05-05");

        orderDao.save(order);
    }

    @Transactional
    private List<Dish> createDishes(List<String> dishes) {
        List<Dish> result = new ArrayList<>();
        for(String dishName: dishes) {
            result.add(dishDao.findByName(dishName));
        }
        return result;
    }

    @Transactional
    public List<Order> getAllOrders() {
        return orderDao.getOrders(true);
    }

    @Transactional
    public void printAllOrders() {
        orderDao.getOrders(true).forEach(System.out::println);
    }

    @Transactional
    public Order getOrderById(int id) {
        return orderDao.getOrderById(id);
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }
}
