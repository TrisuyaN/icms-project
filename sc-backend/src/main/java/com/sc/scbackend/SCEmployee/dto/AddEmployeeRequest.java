package com.sc.scbackend.SCEmployee.dto;

import com.sc.scbackend.SCEmployee.enums.EmployeePosition;
import com.sc.scbackend.SCEmployee.enums.EmployeeStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddEmployeeRequest {

//    private String EmployeeId;

    private String name;

    private EmployeePosition position;

    private EmployeeStatus status;

    private String account;

    private String password;

    private String phoneNumber;

//    private Date hireDate;

//    private Timestamp lastLogin;
}
