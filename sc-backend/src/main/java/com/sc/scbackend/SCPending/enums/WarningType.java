package com.sc.scbackend.SCPending.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WarningType implements IEnum<String> {
    BLUE("蓝色", "蓝色警告"),
    YELLOW("黄色", "黄色警告"),
    ORANGE("橙色", "橙色警告"),
    RED("红色", "红色警告");

    private final String value;
    private final String desc;

    @Override
    public String getValue() {
        return this.value;
    }
}
