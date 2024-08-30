package com.sc.scbackend.controller;

import com.sc.scbackend.base.BaseResult;
import com.sc.scbackend.domain.Employee;
import com.sc.scbackend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sc/api/staff")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(path = "add")
    public ResponseEntity<BaseResult> addEmployee(@ModelAttribute Employee employee) {

        // Employee save 默认保存 password 的 MD5 值
        boolean res = employeeService.save(employee);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("添加成功", employee));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "delete")
    public ResponseEntity<BaseResult> deleteEmployee(@ModelAttribute Employee employee) {
        boolean res = employeeService.removeById(employee);

        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("删除成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "update")
    public ResponseEntity<BaseResult> updateEmployee(@ModelAttribute Employee employee) {

        // Employee updateMD5PwdById 保存 password 的 MD5 值
        boolean res = employeeService.updateMD5PwdById(employee);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("修改成功", employee));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

}
