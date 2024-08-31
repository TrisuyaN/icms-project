package com.sc.scbackend.SCEmployee.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginByAccountPasswordRequest {
    private String account;
    private String password;
}
