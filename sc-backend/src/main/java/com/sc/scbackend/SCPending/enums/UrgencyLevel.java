package com.sc.scbackend.SCPending.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UrgencyLevel implements IEnum<String> {
    LOW("低", "低"),
    MEDIUM("中", "中"),
    HIGH("高", "高");

    private final String value;
    private final String desc;

    @Override
    public String getValue() {
        return this.value;
    }
}
