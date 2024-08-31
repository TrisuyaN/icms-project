package com.sc.scbackend.SCPending.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GreenEnvironmentStatus implements IEnum<String> {
    UNPROCESSED("未处理"),
    PROCESSING("处理中"),
    PROCESSED("已处理");

    private final String value;
}
