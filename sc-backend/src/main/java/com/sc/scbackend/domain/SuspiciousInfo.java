package com.sc.scbackend.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sc.scbackend.enums.CrowdCategory;
import com.sc.scbackend.enums.SuspiciousStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("suspiciousinfo")
public class SuspiciousInfo {

    @TableId(value = "InfoID")
    private String infoId;

    @TableField(value = "LocationID")
    private Integer locationId;

    @TableField(value = "Status")
    private SuspiciousStatus status;

    @TableField(value = "Handler")
    private String handler;

    @TableField(value = "CrowdCategory")
    private CrowdCategory crowdCategory;

    @TableField(value = "RecordTime")
    private Timestamp recordTime;

}
