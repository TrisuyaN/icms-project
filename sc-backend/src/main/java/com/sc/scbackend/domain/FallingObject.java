package com.sc.scbackend.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sc.scbackend.enums.IncidentStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("fallingobjects")
public class FallingObject {

    @TableId(value = "IncidentID")
    private String incidentId;

    private IncidentStatus status;

    @TableField(value = "PropertyID")
    private Integer propertyId;

    @TableField(value = "ResidentID")
    private Integer residentId;

    @TableField(value = "InjuryDescription")
    private String injuryDescription;

    @TableField(value = "IncidentDate")
    private Date incidentDate;

    @TableField(value = "handler")
    private String handler;

    @TableField(value = "handled_at")
    private Date handledAt;

}
