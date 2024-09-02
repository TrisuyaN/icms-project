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
@JsonDeserialize(using = TrashBinViolationTypeDeserializer.class)
public enum TrashBinViolationType implements IBaseEnum<String> {
    IMPROPER_DISPOSAL("Improper Disposal", "不当处置"),
    DAMAGE("Damage", "损坏"),
    OTHER("Other", "其他");

    private final String value;
    private final String desc;

    @Override
    public String getValue() {
        return this.value;
    }
}

class TrashBinViolationTypeDeserializer extends GenericEnumDeserializer<TrashBinViolationType> {
    public TrashBinViolationTypeDeserializer() {
        super(TrashBinViolationType.class);
    }
}
