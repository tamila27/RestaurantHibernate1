package com.goit.gojavaonline.controllers;

import com.goit.gojavaonline.model.dao.EmployeeDao;

/**
 * Created by tamila on 8/22/16.
 */
public class EmployeeController {
    //private PlatformTransactionManager txManager;
    private EmployeeDao employeeDao;

    /*@Transactional
    public List<Employee> getAllEmployee() {
        //return employeeDao.getAll();
        return new ArrayList<>();
    }

    @Transactional
    public Employee getEmployeeByName(String name) {
        //return employeeDao.loadByName(name);

    }

    @Transactional
    public void insertEmployee(Employee employee) {
        employeeDao.insertEmployee(employee);
    }

    @Transactional
    public void deleteEmployee(int id) {
        employeeDao.deleteEmployeeById(id);
    }*/


    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    /*public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }*/
}
