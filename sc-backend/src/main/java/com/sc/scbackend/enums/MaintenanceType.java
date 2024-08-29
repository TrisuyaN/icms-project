package com.sc.scbackend.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MaintenanceType implements IEnum<String> {
    PLANTING("种植", "种植"),
    PRUNING("修剪", "修剪"),
    SPRAYING("喷药", "喷药");

    private final String value;
    private final String desc;

    @Override
    public String getValue() {
        return this.value;
    }
}
