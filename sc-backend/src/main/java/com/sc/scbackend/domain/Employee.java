package com.sc.scbackend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sc.scbackend.base.BaseEntity;
import com.sc.scbackend.enums.EmployeeStatus;
import com.sc.scbackend.enums.EmployeePosition;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;
import java.util.Date;

@EqualsAndHashCode(callSuper = false)
@TableName("employeeinfo")
@Data
public class Employee extends BaseEntity {

    @TableId(value = "EmployeeID", type = IdType.AUTO)
    private String EmployeeId;

    private String name;

    private EmployeePosition position;

    private EmployeeStatus status;

    private String account;

    private String password;

    @TableField(value = "PhoneNumber")
    private String phoneNumber;

    @TableField(value = "HireDate")
    private Date hireDate;

    @TableField(value = "LastLogin")
    private Timestamp lastLogin;

}

