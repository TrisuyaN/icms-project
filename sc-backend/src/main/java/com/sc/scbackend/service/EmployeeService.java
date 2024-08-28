package com.sc.scbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sc.scbackend.domain.Employee;


public interface EmployeeService extends IService<Employee> {
    Employee getByAccount(String account);

    Employee getByPhoneNumber(String phoneNumber);

}
