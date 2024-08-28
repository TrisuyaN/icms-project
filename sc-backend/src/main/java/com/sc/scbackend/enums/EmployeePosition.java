package com.sc.scbackend.enums;


import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum EmployeePosition implements IEnum<String> {
    SUPER_ADMINISTRATOR("超级管理员", "超级管理员"),
    SECURITY_GUARD("保安", "安保人员"),
    CLEANER("保洁", "保洁人员");

    private final String value;
    private final String desc;

    @Override
    public String getValue() {
        return this.value;
    }

}
