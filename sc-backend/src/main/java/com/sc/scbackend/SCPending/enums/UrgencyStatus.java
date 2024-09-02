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
@JsonDeserialize(using = UrgencyStatusDeserializer.class)
public enum UrgencyStatus implements IBaseEnum<String> {
    LOW("低"),
    MEDIUM("中"),
    HIGH("高");

    private final String value;
}

class UrgencyStatusDeserializer extends GenericEnumDeserializer<UrgencyStatus> {
    public UrgencyStatusDeserializer() {
        super(UrgencyStatus.class);
    }
}
