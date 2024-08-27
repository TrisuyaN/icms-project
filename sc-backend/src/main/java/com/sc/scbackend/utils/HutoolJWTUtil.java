package com.sc.scbackend.utils;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;
import com.sc.scbackend.domain.Employee;

import java.util.HashMap;
import java.util.Map;

public class HutoolJWTUtil {

    public static String createToken(Employee employee) {
        DateTime now = DateTime.now();
        DateTime newTime = now.offsetNew(DateField.MINUTE, 120);
        Map<String, Object> payload = new HashMap<String, Object>();
        //签发时间
        payload.put(JWTPayload.ISSUED_AT, now);
        //过期时间
        payload.put(JWTPayload.EXPIRES_AT, newTime);
        //生效时间
        payload.put(JWTPayload.NOT_BEFORE, now);
        //载荷
        payload.put("username", employee.getAccount());
        payload.put("aid", employee.getId());
        String key = "com.sc.rurumuri";
        String token = JWTUtil.createToken(payload, key.getBytes());
        return token;
    }

    public static Long parseToken(String token) {
        final JWT jwt = JWTUtil.parseToken(token);
        return Long.parseLong(jwt.getPayload("aid").toString());
    }
}