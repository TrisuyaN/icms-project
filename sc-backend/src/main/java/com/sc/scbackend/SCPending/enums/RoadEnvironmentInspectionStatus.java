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
@JsonDeserialize(using = RoadEnvironmentInspectionStatusDeserializer.class)
public enum RoadEnvironmentInspectionStatus implements IBaseEnum<String> {
    UNPROCESSED("待处理"),
    PROCESSING("处理中"),
    PROCESSED("已处理");

    private final String value;
}

class RoadEnvironmentInspectionStatusDeserializer extends GenericEnumDeserializer<RoadEnvironmentInspectionStatus> {
    public RoadEnvironmentInspectionStatusDeserializer() {
        super(RoadEnvironmentInspectionStatus.class);
    }
}
