package com.sc.scbackend.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TrashBinViolationType implements IEnum<String> {
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
