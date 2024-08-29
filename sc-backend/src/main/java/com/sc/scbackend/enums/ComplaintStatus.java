package com.sc.scbackend.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ComplaintStatus implements IEnum<String> {
    PENDING("Pending", "待处理"),
    IN_PROGRESS("In Progress", "处理中"),
    RESOLVED("Resolved", "已解决"),
    REJECTED("Rejected", "已拒绝");

    private final String value;
    private final String desc;

    @Override
    public String getValue() {
        return this.value;
    }
}
