package com.sc.scbackend.SCEmployee.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SmsVerificationRequest {

    private String phoneNumber;
    private String code;

}
