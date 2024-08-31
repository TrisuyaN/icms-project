package com.sc.scbackend.SCPending.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UrgencyStatus implements IEnum<String> {
    LOW("低"),
    MEDIUM("中"),
    HIGH("高");

    private final String value;
}