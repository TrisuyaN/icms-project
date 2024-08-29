package com.sc.scbackend.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sc.scbackend.base.BaseEntity;
import com.sc.scbackend.enums.RoadEnvironmentInspectionStatus;
import com.sc.scbackend.enums.RoadEnvironmentInspectionType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("roadenvironmentinspection")
public class RoadEnvironmentInspection extends BaseEntity {

    @TableId(value = "ID")
    private String id;

    @TableField(value = "PointID")
    private Integer pointId;

    @TableField(value = "InspectionType")
    private RoadEnvironmentInspectionType inspectionType;

    @TableField(value = "Status")
    private RoadEnvironmentInspectionStatus inspectionStatus;

    @TableField(value = "carID")
    private String carId;

}
