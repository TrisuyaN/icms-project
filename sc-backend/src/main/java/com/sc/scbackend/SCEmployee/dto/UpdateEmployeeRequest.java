package com.sc.scbackend.SCEmployee.dto;

import com.sc.scbackend.SCEmployee.enums.EmployeePosition;
import com.sc.scbackend.SCEmployee.enums.EmployeeStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UpdateEmployeeRequest {

    private String EmployeeId;

    private String name;

    private EmployeePosition position;

    private EmployeeStatus status;

    private String account;

    private String password;

    private String phoneNumber;

    private Date hireDate;
}
