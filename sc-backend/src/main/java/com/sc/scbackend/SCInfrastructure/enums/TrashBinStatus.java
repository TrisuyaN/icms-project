package com.sc.scbackend.SCInfrastructure.enums;
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
@JsonDeserialize(using = TrashBinStatusDeserializer.class)
public enum TrashBinStatus implements IBaseEnum<String> {
    OPERATIONAL("Operational", "正常运行"),
    FULL("Full", "已满"),
    NEEDS_MAINTENANCE("NeedsMaintenance", "需要维护");

    private final String value;
    private final String desc;

    @Override
    public String getValue() {
        return this.value;
    }
}

class TrashBinStatusDeserializer extends GenericEnumDeserializer<TrashBinStatus> {
    public TrashBinStatusDeserializer() {
        super(TrashBinStatus.class);
    }
}
