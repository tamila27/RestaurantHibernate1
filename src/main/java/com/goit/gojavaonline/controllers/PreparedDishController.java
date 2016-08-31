package com.goit.gojavaonline.controllers;

import com.goit.gojavaonline.model.PreparedDish;
import com.goit.gojavaonline.model.dao.PreparedDishDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tamila on 8/24/16.
 */
public class PreparedDishController {
    private PreparedDishDao preparedDishDao;

    @Transactional
    public void insertPreparedDish(PreparedDish preparedDish){
        preparedDishDao.insertPreparedDish(preparedDish);
    }

    @Transactional
    public List<PreparedDish> getAll() {
        return preparedDishDao.getAll();
    }
    @Transactional
    public void printAll(){
        preparedDishDao.getAll().forEach(System.out::println);
    }


    public void setPreparedDishDao(PreparedDishDao preparedDishDao) {
        this.preparedDishDao = preparedDishDao;
    }
}
