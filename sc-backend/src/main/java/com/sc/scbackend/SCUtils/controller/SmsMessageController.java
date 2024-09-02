package com.sc.scbackend.SCUtils.controller;

import com.sc.scbackend.SCUtils.dto.SMSSendRequest;
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
    public ResponseEntity<BaseResult> verifyCode(@RequestBody SMSVerifyRequest smsVerifyRequest) {
        if(smsMessageService.validateSmsCode(smsVerifyRequest.getPhoneNumber(), smsVerifyRequest.getCode())) {
            return ResponseEntity.ok().body(BaseResult.success("验证成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail("验证成功"));
        }
    }

    @PostMapping(path = "send_code_npnv")
    public ResponseEntity<BaseResult> sendCodeNoPhoneNumberVerify(@RequestBody SMSSendRequest smsSendRequest) throws Exception {
        if(smsMessageService.sendSmsCode(smsSendRequest.getPhoneNumber())) {
            return ResponseEntity.ok().body(BaseResult.success("发送成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail("发送失败"));
        }
    }

}
