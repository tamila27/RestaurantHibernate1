package com.goit.gojavaonline.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by tamila on 8/24/16.
 */
@Entity
@Table(name = "PREPARED_DISH")
public class PreparedDish {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID")
    private int id;

    @OneToOne
    @JoinColumn(name = "DISH_ID")
    private Dish dish;

    @OneToOne
    @JoinColumn(name = "COOK_ID")
    private Employee cook;

    @OneToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @Column(name = "DATE")
    private String date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Employee getCook() {
        return cook;
    }

    public void setCook(Employee cook) {
        this.cook = cook;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "PreparedDish{" +
                "id=" + id +
                ", dish=" + dish +
                ", cook=" + cook +
                ", order=" + order +
                ", date='" + date + '\'' +
                '}';
    }
}
