package com.sc.scbackend.SCInfrastructure.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ManholeCoverStatus implements IEnum<String> {
    PENDING("待处理", "待处理"),
    PROCESSING("处理中", "处理中"),
    PROCESSED("已处理", "已处理");

    private final String value;
    private final String desc;

    @Override
    public String getValue() {
        return this.value;
    }
}