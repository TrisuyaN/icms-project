package com.sc.scbackend.SCResident.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sc.scbackend.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("memberproperty")
public class MemberProperty extends BaseEntity {

    @TableField(value = "MemberID")
    private Integer memberId;

    @TableField(value = "PropertyID")
    private Integer propertyId;

    @TableField(value = "RelationshipType")
    private String relationshipType;

}
