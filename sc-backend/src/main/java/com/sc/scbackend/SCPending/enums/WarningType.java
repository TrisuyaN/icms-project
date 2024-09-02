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
@JsonDeserialize(using = WarningTypeDeserializer.class)
public enum WarningType implements IBaseEnum<String> {
    BLUE("蓝色", "蓝色警告"),
    YELLOW("黄色", "黄色警告"),
    ORANGE("橙色", "橙色警告"),
    RED("红色", "红色警告");

    private final String value;
    private final String desc;

    @Override
    public String getValue() {
        return this.value;
    }
}

class WarningTypeDeserializer extends GenericEnumDeserializer<WarningType> {
    public WarningTypeDeserializer() {
        super(WarningType.class);
    }
}
