package com.sc.scbackend.SCPending.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sc.scbackend.base.IBaseEnum;
import com.sc.scbackend.utils.GenericEnumDeserializer;
import com.sc.scbackend.utils.GenericEnumSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonSerialize(using = GenericEnumSerializer.class)
@JsonDeserialize(using = RoadEnvironmentInspectionTypeDeserializer.class)
public enum RoadEnvironmentInspectionType implements IBaseEnum<String> {
    CLEANING("清洁", "清洁"),
    OBSTRUCTION_REMOVAL("障碍物清除", "障碍物清除"),
    STRAY_ANIMAL("流浪猫狗出没", "流浪猫狗出没"),
    CAR_OBSTRUCTION("汽车占道", "汽车占道");

    private final String value;

    private final String desc;

    @Override
    public String getValue() {
        return this.value;
    }
}

class RoadEnvironmentInspectionTypeDeserializer extends GenericEnumDeserializer<RoadEnvironmentInspectionType> {
    public RoadEnvironmentInspectionTypeDeserializer() {
        super(RoadEnvironmentInspectionType.class);
    }
}