package com.sc.scbackend.SCInfrastructure.enums;

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
@JsonDeserialize(using = DeviceTypeDeserializer.class)
public enum DeviceType implements IBaseEnum<String> {
    SENSOR("Sensor", "传感器"),
    CAMERA("Camera", "摄像头");

    private final String value;
    private final String desc;

    @Override
    public String getValue() {
        return this.value;
    }
}

class DeviceTypeDeserializer extends GenericEnumDeserializer<DeviceType> {
    public DeviceTypeDeserializer() {
        super(DeviceType.class);
    }
}

