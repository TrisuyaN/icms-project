package com.sc.scbackend.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CrowdCategory implements IEnum<String> {
    VISITOR("访客", "访客"),
    RESIDENT("居民", "居民"),
    EMPLOYEE("员工", "员工");

    private final String value;
    private final String desc;

    @Override
    public String getValue() {
        return this.value;
    }
}