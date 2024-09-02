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
@JsonDeserialize(using = GasStatusDeserializer.class)
public enum GasStatus implements IBaseEnum<String> {
    UNPROCESSED("未处理", "未处理"),
    IN_PROGRESS("处理中", "处理中"),
    PROCESSED("已处理", "已处理");

    private final String value;
    private final String desc;

    @Override
    public String getValue() {
        return this.value;
    }
}

class GasStatusDeserializer extends GenericEnumDeserializer<GasStatus> {
    public GasStatusDeserializer() {
        super(GasStatus.class);
    }
}
