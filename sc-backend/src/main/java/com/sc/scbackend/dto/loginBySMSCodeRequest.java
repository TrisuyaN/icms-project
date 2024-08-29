package com.sc.scbackend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class loginBySMSCodeRequest {
    private String phoneNumber;
    private String code;
}
