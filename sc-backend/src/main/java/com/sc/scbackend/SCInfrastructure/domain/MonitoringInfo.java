package com.sc.scbackend.SCInfrastructure.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sc.scbackend.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("monitoringinfo")
public class MonitoringInfo extends BaseEntity {

    @TableId(value = "ID")
    private Integer id;

    @TableField(value = "Video")
    private String video;

    @TableField(value = "PointID")
    private Integer pointId;

}
