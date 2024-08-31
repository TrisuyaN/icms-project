package com.sc.scbackend.SCInfrastructure.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TrashBinType implements IEnum<String> {
    RECYCLING("Recycling", "可回收物"),
    GENERAL("General", "一般垃圾"),
    ORGANIC("Organic", "有机垃圾"),
    HAZARDOUS("Hazardous", "危险废物");

    private final String value;
    private final String desc;

    @Override
    public String getValue() {
        return this.value;
    }
}