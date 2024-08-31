package com.sc.scbackend.SCPending.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sc.scbackend.base.BaseEntity;
import com.sc.scbackend.SCPending.enums.IncidentStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("fallingobjects")
public class FallingObject extends BaseEntity {

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date incidentDate;

    @TableField(value = "handler")
    private String handler;

    @TableField(value = "handled_at")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date handledAt;

}
