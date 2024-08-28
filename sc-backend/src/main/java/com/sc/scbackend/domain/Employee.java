package com.sc.scbackend.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sc.scbackend.base.BaseEntity;
import com.sc.scbackend.enums.AccountStatus;
import com.sc.scbackend.enums.EmployeePosition;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@TableName("employeeinfo")
@Data
public class Employee extends BaseEntity {

    private String id;

    private String name;

    private EmployeePosition position;

    private AccountStatus status;

    private String account;

    private String password;

    @TableField(value = "PhoneNumber")
    private String phoneNumber;

}

