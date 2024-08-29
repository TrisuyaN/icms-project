package com.sc.scbackend.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum IncidentStatus implements IEnum<String> {
    NOT_OCCURRED("未发生", "未发生"),
    OCCURRED("已发生", "已发生");

    private final String value;
    private final String desc;

    @Override
    public String getValue() {
        return this.value;
    }
}
