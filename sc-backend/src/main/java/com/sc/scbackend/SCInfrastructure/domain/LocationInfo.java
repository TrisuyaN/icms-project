package com.sc.scbackend.SCInfrastructure.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sc.scbackend.base.BaseEntity;
import com.sc.scbackend.SCInfrastructure.enums.DeviceType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("locationinfo")
public class LocationInfo extends BaseEntity {

    @TableId(value = "PointID", type = IdType.AUTO)
    private Integer pointId;

    @TableField(value = "LocationName")
    private String locationName;

    @TableField(value = "Device")
    private DeviceType device;

}
