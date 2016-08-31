package com.goit.gojavaonline.controllers;

import com.goit.gojavaonline.model.Dish;
import com.goit.gojavaonline.model.dao.DishDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by tamila on 8/30/16.
 */
public class HDishController {
    private DishDao dishDao;

    @Transactional
    public void createDish() {
        Dish plov = new Dish();
        plov.setName("Plov");
        plov.setCategory(2);
        plov.setPrice(5.0F);
        plov.setWeight(300F);

        Dish salad = new Dish();
        salad.setName("Salad");
        salad.setCategory(2);
        salad.setPrice(2.0F);
        salad.setWeight(100F);

        Dish potato = new Dish();
        potato.setName("Potato");
        potato.setCategory(2);
        potato.setPrice(3.0F);
        potato.setWeight(200F);

        Set<Dish> dishes = new HashSet<>(dishDao.findAll());
        if(!dishes.contains(plov)) {
            dishDao.save(plov);
        }

        if(!dishes.contains(salad)) {
            dishDao.save(salad);
        }

        if(!dishes.contains(potato)) {
            dishDao.save(potato);
        }
    }

    @Transactional
    public List<Dish> getAllDishes() {
        return dishDao.findAll();
    }

    @Transactional
    public Dish getDishByName(String name) {
        return dishDao.findByName(name);
    }

    @Transactional
    public void deleteDish(Dish dish) {
        dishDao.deleteDish(dish);
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }
}
