package com.sc.scbackend.SCEmployee.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sc.scbackend.SCEmployee.domain.Employee;
import com.sc.scbackend.SCEmployee.dto.AddEmployeeRequest;
import com.sc.scbackend.SCEmployee.dto.UpdateEmployeeInfoRequest;


public interface EmployeeService extends IService<Employee> {
    Employee getByAccount(String account);

    Employee getByPhoneNumber(String phoneNumber);

    public boolean updateMD5PwdById(String id, String newPassword);

    public boolean updateInfoById(Employee employee);

    Employee login(Employee employee);

    /*
    * 根据创建账户请求自动生成时间相关字段，生成 Employee 实体。
    * */
    public Employee createFromAddEmployeeRequest(AddEmployeeRequest request);

    public Employee createFromUpdateEmployeeRequest(UpdateEmployeeInfoRequest request);

}
