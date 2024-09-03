package com.sc.scbackend.SCEmployee.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateEmployeePasswordByPhoneNumberRequest {

    private String phoneNumber;

    private String password;

}