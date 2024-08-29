package com.sc.scbackend.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("firehydrants")
public class FireHydrant {

    @TableId(value = "HydrantID")
    private String hydrantId;

    @TableField(value = "LocationID")
    private Integer locationId;

    @TableField(value = "LastInspectionDate")
    private Date lastInspectionDate;

    @TableField(value = "NextInspectionDate")
    private Date nextInspectionDate;

    @TableField(value = "Inspector")
    private String inspector;

    @TableField(value = "IsQualified")
    private Boolean isQualified;

}
