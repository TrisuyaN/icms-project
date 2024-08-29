package com.sc.scbackend.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DeviceType implements IEnum<String> {
    SENSOR("Sensor", "传感器"),
    CAMERA("Camera", "摄像头");

    private final String value;
    private final String desc;

    @Override
    public String getValue() {
        return this.value;
    }
}
