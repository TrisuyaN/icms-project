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
@JsonDeserialize(using = UrgencyLevelDeserializer.class)
public enum UrgencyLevel implements IBaseEnum<String> {
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

class UrgencyLevelDeserializer extends GenericEnumDeserializer<UrgencyLevel> {
    public UrgencyLevelDeserializer() {
        super(UrgencyLevel.class);
    }
}
