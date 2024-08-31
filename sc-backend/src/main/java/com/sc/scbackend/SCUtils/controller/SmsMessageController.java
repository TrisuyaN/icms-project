package com.sc.scbackend.SCUtils.controller;

import com.sc.scbackend.SCUtils.dto.SMSVerifyRequest;
import com.sc.scbackend.SCUtils.service.SmsMessageService;
import com.sc.scbackend.base.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sc/api/sms")
public class SmsMessageController {

    @Autowired
    SmsMessageService smsMessageService;

    @PostMapping(path = "verify")
    public ResponseEntity<BaseResult> addEmployee(@RequestBody SMSVerifyRequest smsVerifyRequest) {
        if(smsMessageService.validateSmsCode(smsVerifyRequest.getPhoneNumber(), smsVerifyRequest.getCode())) {
            return ResponseEntity.ok().body(BaseResult.success());
        } else {
            return ResponseEntity.ok().body(BaseResult.fail());
        }
    }

}
