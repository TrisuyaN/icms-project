package com.sc.scbackend.SCEmployee.controller;

import com.sc.scbackend.base.BaseResult;
import com.sc.scbackend.SCEmployee.domain.Employee;
import com.sc.scbackend.SCEmployee.dto.LoginByAccountPasswordRequest;
import com.sc.scbackend.SCEmployee.dto.LoginByPhoneNumberPasswordRequest;
import com.sc.scbackend.SCEmployee.dto.SendSMSCodeRequest;
import com.sc.scbackend.SCEmployee.dto.loginBySMSCodeRequest;
import com.sc.scbackend.SCEmployee.service.EmployeeService;
import com.sc.scbackend.SCUtils.utils.HutoolJWTUtil;
import com.sc.scbackend.SCUtils.utils.MD5Util;
import com.sc.scbackend.SCUtils.service.SmsMessageService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sc/api")
public class EmployeeLoginController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private SmsMessageService smsMessageService;

    private static final String SMS_CODE_PREFIX = "sms_code:";
    private static final int EXPIRATION_TIME = 5; // 过期时间（分钟）


    @PostMapping(path = "login")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400")
    })
    public ResponseEntity<BaseResult> loginByAccountAndPassword(@RequestBody LoginByAccountPasswordRequest request) {
        Employee loginEmployee = employeeService.getByAccount(request.getAccount());
        if (loginEmployee == null) {
            return ResponseEntity.badRequest().body(BaseResult.fail("登录失败，账号不存在"));
        } else if (!loginEmployee.getPassword().equals(MD5Util.MD5(request.getPassword()))) {
//        } else if (!loginEmployee.getPassword().equals(request.getPassword())) {
            return ResponseEntity.badRequest().body(BaseResult.fail("登录失败，账号或密码不正确"));
        }

        // 登录
        loginEmployee = employeeService.login(loginEmployee);

        Map<String, Object> resultMap = generateLoginResultData(loginEmployee);

        return ResponseEntity.ok().body(BaseResult.success("登录成功", resultMap));
    }

    @PostMapping(path = "login_phone")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400")
    })
    public ResponseEntity<BaseResult> loginByPhoneNumberAndPassword(@RequestBody LoginByPhoneNumberPasswordRequest request) {
        Employee loginEmployee = employeeService.getByPhoneNumber(request.getPhoneNumber());
        if (loginEmployee == null) {
            return ResponseEntity.badRequest().body(BaseResult.fail("登录失败，账号不存在"));
        } else if (!loginEmployee.getPassword().equals(MD5Util.MD5(request.getPassword()))) {
//        } else if (!loginEmployee.getPassword().equals(request.getPassword())) {
            return ResponseEntity.badRequest().body(BaseResult.fail("登录失败，手机号或密码不正确"));
        }

        // 登录
        loginEmployee = employeeService.login(loginEmployee);

        Map<String, Object> resultMap = generateLoginResultData(loginEmployee);

        return ResponseEntity.ok().body(BaseResult.success("登录成功", resultMap));
    }

    @PostMapping(path = "send_code")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400"),
    })
    public ResponseEntity<BaseResult> sendSMSCode(@RequestBody SendSMSCodeRequest request) throws Exception {
        Employee loginEmployee = employeeService.getByPhoneNumber(request.getPhoneNumber());
        if (loginEmployee == null) {
            return ResponseEntity.badRequest().body(BaseResult.fail("发送失败，账号不存在"));
        }

        boolean codeSendRes = smsMessageService.sendSmsCode(loginEmployee.getPhoneNumber());
        if (codeSendRes) {
            return ResponseEntity.ok().body(BaseResult.success("发送成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail("发送失败"));
        }
    }

    @PostMapping(path = "login_code")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400"),
    })
    public ResponseEntity<BaseResult> loginBySMSCode(@RequestBody loginBySMSCodeRequest request) {
        Employee login_employee = employeeService.getByPhoneNumber(request.getPhoneNumber());

        if (login_employee == null) {
            return ResponseEntity.badRequest().body(BaseResult.fail("登录失败，账号不存在"));
        } else {
            boolean validateRes = smsMessageService.validateSmsCode(request.getPhoneNumber(), request.getCode());
            if (!validateRes) {
                return ResponseEntity.badRequest().body(BaseResult.fail("登录失败，验证码错误"));
            }
        }

        login_employee = employeeService.login(login_employee);
        Map<String, Object> resultMap = generateLoginResultData(login_employee);

        return ResponseEntity.ok().body(BaseResult.success("登录成功", resultMap));
    }

    // TODO
    @PostMapping("logout")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200")
    })
    public ResponseEntity<BaseResult> loginOut() {
        return ResponseEntity.ok().body(BaseResult.success("登出成功"));
    }

    private Map<String, Object> generateLoginResultData(Employee employee) {
        // 生成token
        String token = HutoolJWTUtil.createToken(employee);

        // password 不应添加到 resultMap
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("token", token);
        resultMap.put("account", employee.getAccount());
        resultMap.put("id", employee.getEmployeeId());
        resultMap.put("name", employee.getName());
        resultMap.put("position", employee.getPosition().getValue());
        resultMap.put("status", employee.getStatus().getValue());
        resultMap.put("phone_number", employee.getPhoneNumber());
        resultMap.put("hire_date", employee.getHireDate());
        resultMap.put("last_login", employee.getLastLogin());

        return resultMap;
    }

}
