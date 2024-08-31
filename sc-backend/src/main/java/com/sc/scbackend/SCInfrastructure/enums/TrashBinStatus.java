package com.sc.scbackend.SCInfrastructure.enums;
import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TrashBinStatus implements IEnum<String> {
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
