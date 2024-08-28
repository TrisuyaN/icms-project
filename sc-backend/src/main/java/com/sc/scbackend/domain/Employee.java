package com.sc.scbackend.domain;

//import com.sc.scbackend.enums.AccountStatusImpl;
//import com.sc.scbackend.enums.EmployeePositionImpl;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sc.scbackend.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

@EqualsAndHashCode(callSuper = false)
@TableName("employeeinfo")
@Data
public class Employee extends BaseEntity {

    private String id;

    private String name;

    // TODO: 使用 Java 枚举直接映射
    private String position;

    // TODO: 使用 Java 枚举直接映射
    private String status;

    private String account;

    private String password;

    @TableField(value = "PhoneNumber")
    private String phoneNumber;

}

