package com.sc.scbackend.domain;

//import com.sc.scbackend.enums.AccountStatusImpl;
//import com.sc.scbackend.enums.EmployeePositionImpl;
import com.sc.scbackend.base.BaseEntity;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Employee extends BaseEntity {

    private String id;

    private String name;

    // TODO: 使用 Java 枚举直接映射
    private String position;

    // TODO: 使用 Java 枚举直接映射
    private String status;

    private String account;

    private String password;

    private String phoneNumber;

}

