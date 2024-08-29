package com.sc.scbackend.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sc.scbackend.base.BaseEntity;
import com.sc.scbackend.enums.ManholeCoverStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("manholecovers")
public class ManholeCover extends BaseEntity {

    @TableId(value = "CoverID")
    private String coverId;

    @TableField(value = "LocationID")
    private Integer locationId;

    @TableField(value = "CoverExists")
    private Boolean coverExists;

    @TableField(value = "CoverDamaged")
    private Boolean coverDamaged;

    @TableField(value = "Status")
    private ManholeCoverStatus status;

}
