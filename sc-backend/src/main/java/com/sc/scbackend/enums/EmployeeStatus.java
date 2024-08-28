package com.sc.scbackend.enums;


import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum EmployeeStatus implements IEnum<String> {
    ACTIVE("在职", "在职"),
    INACTIVE("离职", "离职"),
    ON_LEAVE("休假", "休假中");

    private final String value;
    private final String desc;

    @Override
    public String getValue() {
        return this.value;
    }
}

