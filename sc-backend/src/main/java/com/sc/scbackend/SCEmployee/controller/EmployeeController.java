package com.sc.scbackend.SCEmployee.controller;

import com.sc.scbackend.SCEmployee.dto.UpdateEmployeeRequest;
import com.sc.scbackend.base.BaseResult;
import com.sc.scbackend.SCEmployee.domain.Employee;
import com.sc.scbackend.SCEmployee.dto.AddEmployeeRequest;
import com.sc.scbackend.SCEmployee.dto.DeleteEmployeeRequest;
import com.sc.scbackend.SCEmployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sc/api/staff")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(path = "add")
    public ResponseEntity<BaseResult> addEmployee(@RequestBody AddEmployeeRequest addEmployeeRequest) {

        // TODO：值非空非重复检查

        Employee employee = employeeService.createFromAddEmployeeRequest(addEmployeeRequest);

        // Employee save 默认保存 password 的 MD5 值
        boolean res = employeeService.save(employee);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("添加成功", employee));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "delete")
    public ResponseEntity<BaseResult> deleteEmployee(@RequestBody DeleteEmployeeRequest deleteEmployeeRequest) {

        // TODO：非空检查

        boolean res = employeeService.removeById(deleteEmployeeRequest.getEmployeeId());

        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("删除成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "update")
    public ResponseEntity<BaseResult> updateEmployee(@RequestBody UpdateEmployeeRequest updateEmployeeRequest) {

        Employee employee = employeeService.createFromUpdateEmployeeRequest(updateEmployeeRequest);

        // Employee updateMD5PwdById 保存 password 的 MD5 值
        boolean res = employeeService.updateMD5PwdById(employee);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("修改成功", employee));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

}
