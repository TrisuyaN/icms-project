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
@JsonDeserialize(using = MaintenanceTypeDeserializer.class)
public enum MaintenanceType implements IBaseEnum<String> {
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

class MaintenanceTypeDeserializer extends GenericEnumDeserializer<MaintenanceType> {
    public MaintenanceTypeDeserializer() {
        super(MaintenanceType.class);
    }
}
