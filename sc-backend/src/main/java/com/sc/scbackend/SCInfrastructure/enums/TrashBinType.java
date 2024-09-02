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
@JsonDeserialize(using = TrashBinTypeDeserializer.class)
public enum TrashBinType implements IBaseEnum<String> {
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

class TrashBinTypeDeserializer extends GenericEnumDeserializer<TrashBinType> {
    public TrashBinTypeDeserializer() {
        super(TrashBinType.class);
    }
}
