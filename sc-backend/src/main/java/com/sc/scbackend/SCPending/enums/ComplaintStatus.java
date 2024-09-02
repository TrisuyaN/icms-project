package com.sc.scbackend.SCPending.enums;

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
@JsonDeserialize(using = ComplaintStatusDeserializer.class)
public enum ComplaintStatus implements IBaseEnum<String> {
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

class ComplaintStatusDeserializer extends GenericEnumDeserializer<ComplaintStatus> {
    public ComplaintStatusDeserializer() {
        super(ComplaintStatus.class);
    }
}
