package com.sc.scbackend.SCEmployee.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginByPhoneNumberPasswordRequest {
    private String phoneNumber;
    private String password;
}
