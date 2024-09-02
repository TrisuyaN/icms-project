package com.sc.scbackend.SCEmployee.enums;


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
@JsonDeserialize(using = EmployeeStatusDeserializer.class)
public enum EmployeeStatus implements IBaseEnum<String> {
    ACTIVE("在职", "在职"),
    INACTIVE("离职", "离职"),
    ON_LEAVE("休假", "休假中");

    private final String value;
    private final String desc;

    @Override
    public String getValue() {
        return this.value;
    }
}

class EmployeeStatusDeserializer extends GenericEnumDeserializer<EmployeeStatus> {
    public EmployeeStatusDeserializer() {
        super(EmployeeStatus.class);
    }
}