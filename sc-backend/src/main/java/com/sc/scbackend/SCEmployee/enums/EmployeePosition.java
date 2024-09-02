package com.sc.scbackend.SCEmployee.enums;


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
@JsonDeserialize(using = EmployeePositionDeserializer.class)
public enum EmployeePosition implements IBaseEnum<String> {
    SUPER_ADMINISTRATOR("超级管理员", "超级管理员"),
    SECURITY_GUARD("保安", "安保人员"),
    CLEANER("保洁", "保洁人员");

    private final String value;
    private final String desc;

    @Override
    public String getValue() {
        return this.value;
    }

}


class EmployeePositionDeserializer extends GenericEnumDeserializer<EmployeePosition> {
    public EmployeePositionDeserializer() {
        super(EmployeePosition.class);
    }
}

