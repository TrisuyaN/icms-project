package com.sc.scbackend.SCEmployee.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sc.scbackend.base.BaseEntity;
import com.sc.scbackend.SCEmployee.enums.EmployeeStatus;
import com.sc.scbackend.SCEmployee.enums.EmployeePosition;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;

@EqualsAndHashCode(callSuper = false)
@TableName("employeeinfo")
@Data
public class Employee extends BaseEntity {

    @TableId(value = "EmployeeID")
    private String EmployeeId;

    private String name;

    private EmployeePosition position;

    private EmployeeStatus status;

    private String account;

    private String password;

    @TableField(value = "PhoneNumber")
    private String phoneNumber;

    @TableField(value = "HireDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hireDate;

    @TableField(value = "LastLogin")
    private Timestamp lastLogin;

}

