package com.sc.scbackend.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sc.scbackend.enums.DeviceType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("locationinfo")
public class LocationInfo {

    @TableId(value = "PointID")
    private Integer pointId;

    @TableField(value = "LocationName")
    private String locationName;

    @TableField(value = "Device")
    private DeviceType device;

}
