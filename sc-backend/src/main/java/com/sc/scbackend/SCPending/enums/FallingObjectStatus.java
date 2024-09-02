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
@JsonDeserialize(using = FallingObjectStatusDeserializer.class)
public enum FallingObjectStatus implements IBaseEnum<String> {
    NOT_OCCURRED("未发生", "未发生"),
    OCCURRED("已发生", "已发生");

    private final String value;
    private final String desc;

    @Override
    public String getValue() {
        return this.value;
    }
}

class FallingObjectStatusDeserializer extends GenericEnumDeserializer<FallingObjectStatus> {
    public FallingObjectStatusDeserializer() {
        super(FallingObjectStatus.class);
    }
}
