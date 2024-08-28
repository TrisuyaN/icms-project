package com.sc.scbackend.controller;

import com.sc.scbackend.base.BaseResult;
import com.sc.scbackend.domain.Employee;
import com.sc.scbackend.dto.SmsVerificationRequest;
import com.sc.scbackend.enums.EmployeeStatus;
import com.sc.scbackend.service.EmployeeService;
import com.sc.scbackend.utils.HutoolJWTUtil;
import com.sc.scbackend.utils.MD5Util;
import com.sc.scbackend.utils.SmsMessageService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/sc/api/employee")
public class EmployeeLoginController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private SmsMessageService smsMessageService;

    private static final String SMS_CODE_PREFIX = "sms_code:";
    private static final int EXPIRATION_TIME = 5; // 过期时间（分钟）

    @PostMapping("loginByAccountAndPassword")
    public BaseResult loginByAccountAndPassword(@RequestBody Employee employee, HttpServletRequest request) {
        Employee login_employee = employeeService.getByAccount(employee.getAccount());
        if (login_employee == null) {
            return BaseResult.fail("登录失败，账号不存在");
        } else if (!login_employee.getPassword().equals(MD5Util.MD5(employee.getPassword()))) {
            return BaseResult.fail("登录失败，密码不正确");
        } else if (Objects.equals(login_employee.getStatus(), EmployeeStatus.INACTIVE.name())) {
            return BaseResult.fail("登录失败，账号未激活或被封禁，请联系系统管理员");
        }

        // 生成token
        String token = HutoolJWTUtil.createToken(login_employee);
        request.setAttribute("token", token);

        // 创建响应
        // password 不应添加到 resultMap
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("token", token);
        resultMap.put("account", login_employee.getAccount());
        resultMap.put("id", login_employee.getEmployeeId());
        resultMap.put("name", login_employee.getName());
        resultMap.put("position", login_employee.getPosition());
        resultMap.put("status", login_employee.getStatus());

        return BaseResult.success("登录成功", resultMap);
    }

    @PostMapping("loginByPhoneAndPassword")
    public BaseResult loginByPhoneNumberAndPassword(@RequestBody Employee employee, HttpServletRequest request) {
        Employee login_employee = employeeService.getByPhoneNumber(employee.getPhoneNumber());
        if (login_employee == null) {
            return BaseResult.fail("登录失败，账号不存在");
        } else if (!login_employee.getPassword().equals(MD5Util.MD5(employee.getPassword()))) {
            return BaseResult.fail("登录失败，密码不正确");
        } else if (Objects.equals(login_employee.getStatus(), EmployeeStatus.INACTIVE.name())) {
            return BaseResult.fail("登录失败，账号未激活或被封禁，请联系系统管理员");
        }

        // 生成token
        String token = HutoolJWTUtil.createToken(login_employee);
        request.setAttribute("token", token);

        // 创建响应
        // password 不应添加到 resultMap
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("token", token);
        resultMap.put("account", login_employee.getAccount());
        resultMap.put("id", login_employee.getEmployeeId());
        resultMap.put("name", login_employee.getName());
        resultMap.put("position", login_employee.getPosition());
        resultMap.put("status", login_employee.getStatus());

        return BaseResult.success("登录成功", resultMap);
    }

    @PostMapping("sendSMSCode")
    public BaseResult sendSMSCode(@RequestBody Employee employee) throws Exception {
        String code;
        Employee loginEmployee = employeeService.getByPhoneNumber(employee.getPhoneNumber());
        if (loginEmployee == null) {
            return BaseResult.fail("登录失败，账号不存在");
        }

        boolean codeSendRes = smsMessageService.sendSmsCode(loginEmployee.getPhoneNumber());
        if (codeSendRes) {
            return BaseResult.success();
        } else {
            return BaseResult.fail();
        }


    }

    @PostMapping("loginBySMSCode")
    public BaseResult loginBySMSCode(@RequestBody SmsVerificationRequest smsVerificationRequest, HttpServletRequest request) {
        Employee login_employee = employeeService.getByPhoneNumber(smsVerificationRequest.getPhoneNumber());

        if (login_employee == null) {
            return BaseResult.fail("登录失败，账号不存在");
        } else if (Objects.equals(login_employee.getStatus(), EmployeeStatus.INACTIVE.name())) {
            return BaseResult.fail("登录失败，账号未激活或被封禁，请联系系统管理员");
        } else {
            boolean validateRes = smsMessageService.validateSmsCode(smsVerificationRequest.getPhoneNumber(), smsVerificationRequest.getCode());
            if (!validateRes) {
                return BaseResult.fail("登录失败，验证码错误");
            }
        }

        // 生成token
        String token = HutoolJWTUtil.createToken(login_employee);
        request.setAttribute("token", token);

        // 创建响应
        // password 不应添加到 resultMap
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("token", token);
        resultMap.put("account", login_employee.getAccount());
        resultMap.put("id", login_employee.getEmployeeId());
        resultMap.put("name", login_employee.getName());
        resultMap.put("position", login_employee.getPosition());
        resultMap.put("status", login_employee.getStatus());

        return BaseResult.success("登录成功", resultMap);
    }

    @GetMapping("loginOut")
    public BaseResult loginOut(HttpServletRequest request) {
        request.getServletContext().removeAttribute("token");
        return BaseResult.success("退出成功");
    }
}
