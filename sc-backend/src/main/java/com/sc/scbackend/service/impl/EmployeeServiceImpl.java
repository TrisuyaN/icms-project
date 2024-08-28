package com.sc.scbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.scbackend.dao.EmployeeDao;
import com.sc.scbackend.domain.Employee;
import com.sc.scbackend.service.EmployeeService;
import com.sc.scbackend.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class EmployeeServiceImpl extends ServiceImpl<EmployeeDao, Employee> implements EmployeeService {

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
    public boolean save(Employee employee) {
        // 加密逻辑
        employee.setPassword(MD5Util.MD5(employee.getPassword()));
        employeeDao.insert(employee);
        return employeeDao.getByAccount(employee.getAccount()) != null;
    }

    @Override
    public boolean updateById(Employee employee) {
        // 加密逻辑
        employee.setPassword(MD5Util.MD5(employee.getPassword()));
        employeeDao.updateById(employee);
        return employeeDao.getByAccount(employee.getAccount()) != null;
    }
}
