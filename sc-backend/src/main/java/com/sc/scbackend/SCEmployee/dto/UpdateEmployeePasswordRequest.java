package com.sc.scbackend.SCEmployee.dto;

import com.sc.scbackend.SCEmployee.enums.EmployeePosition;
import com.sc.scbackend.SCEmployee.enums.EmployeeStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UpdateEmployeePasswordRequest {

    private String EmployeeId;

    private String password;

}