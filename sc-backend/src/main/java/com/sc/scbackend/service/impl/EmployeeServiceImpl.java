package com.sc.scbackend.service.impl;

import com.sc.scbackend.dao.EmployeeDao;
import com.sc.scbackend.domain.Employee;
import com.sc.scbackend.service.EmployeeService;
import com.sc.scbackend.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public Employee getByAccount(@NonNull String account) {
        return employeeDao.getByAccount(account);
    }

    @Override
    public Employee getByPhoneNumber(String phoneNumber) {
        return employeeDao.getByPhoneNumber(phoneNumber);
    }

    @Override
    public boolean insertEmployee(Employee employee) {
        // 加密逻辑
        employee.setPassword(MD5Util.MD5(employee.getPassword()));
        employeeDao.insert(employee);
        return employeeDao.getByAccount(employee.getAccount()) != null;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        // 加密逻辑
        employee.setPassword(MD5Util.MD5(employee.getPassword()));
        employeeDao.update(employee);
        return employeeDao.getByAccount(employee.getAccount()) != null;
    }

    @Override
    public boolean deleteEmployee(Employee employee) {
        employeeDao.delete(employee);
        return employeeDao.getByAccount(employee.getAccount()) == null;
    }

    @Override
    public Employee getById(String id) {
        return employeeDao.getById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.getAll();
    }

//    @Override
//    public Employee login(Employee employee) {
//        return employeeDao.getByAccount(employee.getAccount());
//    }
}
