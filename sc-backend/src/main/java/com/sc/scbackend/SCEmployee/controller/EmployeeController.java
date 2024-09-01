package com.sc.scbackend.SCEmployee.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sc.scbackend.SCEmployee.domain.Employee;
import com.sc.scbackend.SCEmployee.dto.*;
import com.sc.scbackend.SCEmployee.service.EmployeeService;
import com.sc.scbackend.base.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @PostMapping(path = "update_info")
    public ResponseEntity<BaseResult> updateEmployeeInfo(@RequestBody UpdateEmployeeInfoRequest updateEmployeeInfoRequest) {

        Employee employee = employeeService.createFromUpdateEmployeeRequest(updateEmployeeInfoRequest);

        boolean res = employeeService.updateInfoById(employee);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("修改成功", employee));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "update_passwd")
    public ResponseEntity<BaseResult> updateEmployeePassword(@RequestBody UpdateEmployeePasswordRequest updateEmployeeInfoRequest) {

        boolean res = employeeService.updateMD5PwdById(updateEmployeeInfoRequest.getEmployeeId(), updateEmployeeInfoRequest.getPassword());
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("修改成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "findall")
    public ResponseEntity<BaseResult> selectAllEmployee() {
        List<Employee> res = employeeService.list();
        if (res != null) {
            return ResponseEntity.ok().body(BaseResult.success("查询成功", res));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "findbycondition")
    public ResponseEntity<BaseResult> selectBy(@RequestBody SelectEmployeeRequest selectEmployeeRequest) {

        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        if (selectEmployeeRequest.getAccount() != null) {
            queryWrapper.eq("Account", selectEmployeeRequest.getAccount());
        }
        if (selectEmployeeRequest.getPosition() != null) {
            queryWrapper.eq("Position", selectEmployeeRequest.getPosition());
        }
        if (selectEmployeeRequest.getName() != null) {
            queryWrapper.like("Name", selectEmployeeRequest.getName());
        }
        if (selectEmployeeRequest.getStatus() != null) {
            queryWrapper.eq("Status", selectEmployeeRequest.getStatus());
        }

        List<Employee> res = employeeService.list(queryWrapper);
        if (res != null) {
            return ResponseEntity.ok().body(BaseResult.success("查询成功", res));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

}
