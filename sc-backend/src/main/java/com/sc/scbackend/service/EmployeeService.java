package com.sc.scbackend.service;

import com.sc.scbackend.domain.Employee;

import java.util.List;


public interface EmployeeService {
    Employee getByAccount(String account);

    Employee getByPhoneNumber(String phoneNumber);

    boolean insertEmployee(Employee employee);

    boolean updateEmployee(Employee employee);

    boolean deleteEmployee(Employee employee);

    Employee getById(String id);

    List<Employee> getAllEmployees();

}
