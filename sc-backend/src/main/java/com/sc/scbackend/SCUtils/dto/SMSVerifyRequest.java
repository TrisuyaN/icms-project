package com.sc.scbackend.SCUtils.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SMSVerifyRequest {
    private String phoneNumber;
    private String code;
}
