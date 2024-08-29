package com.sc.scbackend.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoadEnvironmentInspectionType implements IEnum<String> {
    CLEANING("清洁", "清洁"),
    OBSTRUCTION_REMOVAL("障碍物清除", "障碍物清除"),
    STRAY_ANIMAL("流浪猫狗出没", "流浪猫狗出没");

    private final String value;
    private final String desc;

    @Override
    public String getValue() {
        return this.value;
    }
}