package com.sc.scbackend.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component
public class SmsMessageService {

    @Autowired
    private SmsMessageUtil smsMessageUtil;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private static final String SMS_CODE_PREFIX = "sms_code:";
    private static final int EXPIRATION_TIME = 5; // 过期时间（分钟）

    public boolean sendSmsCode(String phoneNumber) throws Exception {
        String smsCode = String.valueOf(new Random().nextInt(899999) + 100000); // 生成 6 位随机数
        boolean res = smsMessageUtil.sendMessage(phoneNumber, smsCode);
        redisTemplate.opsForValue().set(SMS_CODE_PREFIX + phoneNumber, smsCode, EXPIRATION_TIME, TimeUnit.MINUTES);
        return res;
    }

    public boolean validateSmsCode(String phoneNumber, String code) {
        String storedCode = redisTemplate.opsForValue().get(SMS_CODE_PREFIX + phoneNumber);
        return code.equals(storedCode);
    }
}
