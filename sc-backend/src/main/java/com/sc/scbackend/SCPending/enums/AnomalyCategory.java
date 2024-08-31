package com.sc.scbackend.SCPending.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AnomalyCategory implements IEnum<String> {
    WATER("水"),
    ELECTRICITY("电");

    private final String value;

}