package com.goit.gojavaonline.controllers;

import com.goit.gojavaonline.model.Employee;
import com.goit.gojavaonline.model.dao.EmployeeDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by tamila on 8/29/16.
 */

public class HEmployeeController {
    private EmployeeDao employeeDao;

    @Transactional
    public void createEmployee() {
        Set<Employee> allEmployees = new HashSet<>(employeeDao.findAll());

        Employee employee = new Employee();
        employee.setName("John");
        employee.setLastName("Smith");
        employee.setPosition(0);
        employee.setPhone("0987654321");
        employee.setSalary(10000.00F);

        if(!allEmployees.contains(employee)){
            employeeDao.save(employee);
        }
    }

    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }

    @Transactional
    public Employee getEmployeeByName(String name) {
        return employeeDao.findByName(name);
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
