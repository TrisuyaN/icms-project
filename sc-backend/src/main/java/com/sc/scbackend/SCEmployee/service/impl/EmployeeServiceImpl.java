package com.sc.scbackend.SCEmployee.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.scbackend.SCEmployee.dao.EmployeeDao;
import com.sc.scbackend.SCEmployee.domain.Employee;
import com.sc.scbackend.SCEmployee.dto.AddEmployeeRequest;
import com.sc.scbackend.SCEmployee.dto.UpdateEmployeeInfoRequest;
import com.sc.scbackend.SCEmployee.service.EmployeeService;
import com.sc.scbackend.SCUtils.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Timestamp;

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
    public Employee login(Employee loginEmployee) {
        // 更新最后登录的时间
        loginEmployee.setLastLogin(new Timestamp(System.currentTimeMillis()));
        employeeDao.updateById(loginEmployee);
        return loginEmployee;
    }

    @Override
    public boolean save(Employee employee) {
        // 加密逻辑
        employee.setPassword(MD5Util.MD5(employee.getPassword()));
        employeeDao.insert(employee);
        return employeeDao.getByAccount(employee.getAccount()) != null;
    }


    public boolean updateMD5PwdById(String id, String newPassword) {

        Employee employee = employeeDao.selectById(id);

        // 加密逻辑
        employee.setPassword(MD5Util.MD5(newPassword));
        employeeDao.updateById(employee);
        return employeeDao.getByAccount(employee.getAccount()) != null;
    }

    @Override
    public boolean updateMD5PwdByPhoneNumber(String phoneNumber, String newPassword) {

        Employee employee = employeeDao.getByPhoneNumber(phoneNumber);

        // 加密逻辑
        employee.setPassword(MD5Util.MD5(newPassword));
        employeeDao.updateById(employee);
        return employeeDao.getByAccount(employee.getAccount()) != null;
    }

    @Override
    public boolean updateInfoById(Employee employee) {
        employee.setPassword(employeeDao.selectById(employee.getEmployeeId()).getPassword()); // 使用原 password
        employeeDao.updateById(employee);
        return employeeDao.getByAccount(employee.getAccount()) != null;
    }

    public Employee createFromAddEmployeeRequest(AddEmployeeRequest request) {
        Employee employee = new Employee();
        employee.setName(request.getName());
        employee.setPosition(request.getPosition());
        employee.setStatus(request.getStatus());
        employee.setAccount(request.getAccount());
        employee.setPassword(request.getPassword());
        employee.setPhoneNumber(request.getPhoneNumber());
        employee.setHireDate(new Date(System.currentTimeMillis()));
        employee.setLastLogin(new Timestamp(System.currentTimeMillis()));
        return employee;
    }

    @Override
    public Employee createFromUpdateEmployeeRequest(UpdateEmployeeInfoRequest request) {
        Employee employee = new Employee();
        employee.setEmployeeId(request.getEmployeeId());
        employee.setName(request.getName());
        employee.setPosition(request.getPosition());
        employee.setStatus(request.getStatus());
        employee.setAccount(request.getAccount());
//        employee.setPassword(request.getPassword());
        employee.setPhoneNumber(request.getPhoneNumber());
        employee.setHireDate(request.getHireDate());
        employee.setLastLogin(new Timestamp(System.currentTimeMillis()));
        return employee;
    }
}
