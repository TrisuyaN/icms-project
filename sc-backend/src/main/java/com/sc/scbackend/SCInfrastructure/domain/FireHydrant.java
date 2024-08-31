package com.sc.scbackend.SCInfrastructure.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sc.scbackend.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("firehydrants")
public class FireHydrant extends BaseEntity {

    @TableId(value = "HydrantID")
    private String hydrantId;

    @TableField(value = "LocationID")
    private Integer locationId;

    @TableField(value = "LastInspectionDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lastInspectionDate;

    @TableField(value = "NextInspectionDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date nextInspectionDate;

    @TableField(value = "Inspector")
    private String inspector;

    @TableField(value = "IsQualified")
    private Boolean isQualified;

}
