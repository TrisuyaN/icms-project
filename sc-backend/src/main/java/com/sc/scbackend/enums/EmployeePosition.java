package com.sc.scbackend.enums;


import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum EmployeePosition implements IEnum<String> {
    SUPER_ADMINISTRATOR("Super Administrator", "超级管理员"),
    SECURITY_GUARD("Security Guard", "安保人员"),
    CLEANER("Cleaner", "保洁人员");

    private final String value;
    private final String desc;

    @Override
    public String getValue() {
        return this.value;
    }

}
