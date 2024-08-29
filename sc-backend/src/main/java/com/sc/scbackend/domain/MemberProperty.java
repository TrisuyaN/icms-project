package com.sc.scbackend.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("memberproperty")
public class MemberProperty {

    @TableId(value = "MemberID")
    private Integer memberId;

    @TableField(value = "PropertyID")
    private Integer propertyId;

    @TableField(value = "RelationshipType")
    private String relationshipType;

}
