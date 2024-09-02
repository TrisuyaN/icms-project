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
@JsonDeserialize(using = AnomalyCategoryDeserializer.class)
public enum AnomalyCategory implements IBaseEnum<String> {
    WATER("水"),
    ELECTRICITY("电");

    private final String value;

}

class AnomalyCategoryDeserializer extends GenericEnumDeserializer<AnomalyCategory> {
    public AnomalyCategoryDeserializer() {
        super(AnomalyCategory.class);
    }
}
