package com.sc.scbackend.SCPending.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sc.scbackend.base.BaseEntity;
import com.sc.scbackend.SCPending.enums.GreenEnvironmentStatus;
import com.sc.scbackend.SCPending.enums.MaintenanceType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("greenenvironmentinfo")
public class GreenEnvironmentInfo extends BaseEntity {

    @TableId(value = "ID")
    private String id;

    @TableField(value = "PointID")
    private Integer pointId;

    @TableField(value = "MaintenanceType")
    private MaintenanceType maintenanceType;

    @TableField(value = "Status")
    private GreenEnvironmentStatus greenEnvironmentStatus;

}
