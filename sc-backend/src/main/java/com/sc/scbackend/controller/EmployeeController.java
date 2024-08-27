package com.sc.scbackend.controller;

import com.sc.scbackend.base.BaseResult;
import com.sc.scbackend.domain.Employee;
import com.sc.scbackend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sc/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("register")
    public BaseResult addEmployee(@RequestBody Employee employee) {
        boolean res =  employeeService.insertEmployee(employee);
        if(res) {
            return BaseResult.success(employee);
        } else {
            return BaseResult.fail();
        }
    }

    @PostMapping({"update", "changePassword"})
    public BaseResult changeInfoEmployee(@RequestBody Employee employee) {
        boolean res =  employeeService.updateEmployee(employee);
        if(res) {
            return BaseResult.success(employee);
        } else {
            return BaseResult.fail();
        }
    }

    @PostMapping("delete")
    public BaseResult deleteEmployee(@RequestBody Employee employee) {
        boolean res =  employeeService.deleteEmployee(employee);
        if(res) {
            return BaseResult.success(employee);
        } else {
            return BaseResult.fail();
        }
    }

}
