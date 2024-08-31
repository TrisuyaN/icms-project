package com.sc.scbackend.SCPending.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sc.scbackend.base.BaseEntity;
import com.sc.scbackend.SCPending.enums.AnomalyCategory;
import com.sc.scbackend.SCPending.enums.ProcessingStatus;
import com.sc.scbackend.SCPending.enums.UrgencyStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = false)
@TableName("anomalies")
@Data
public class Anomaly extends BaseEntity {

    @TableId(value = "AnomalyID")
    private String anomalyId;

    @TableField(value = "LocationID")
    private int locationId;

    @TableField(value = "ErrorMessage")
    private String errorMessage;

    private AnomalyCategory category;

    @TableField(value = "UrgencyStatus")
    private UrgencyStatus urgencyStatus;

    @TableField(value = "ProcessingStatus")
    private ProcessingStatus processingStatus;

    @TableField(value = "RecordTime")
    private Timestamp recordTime;

}