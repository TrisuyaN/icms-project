package com.sc.scbackend.enums;


import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum AccountStatus implements IEnum<String> {
    ACTIVE("Active", "已激活"),
    INACTIVE("Inactive", "未激活");

    private final String value;
    private final String desc;

    @Override
    public String getValue() {
        return this.value;
    }

}

