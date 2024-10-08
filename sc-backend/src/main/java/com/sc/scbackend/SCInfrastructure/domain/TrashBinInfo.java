package com.sc.scbackend.SCInfrastructure.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sc.scbackend.base.BaseEntity;
import com.sc.scbackend.SCInfrastructure.enums.TrashBinStatus;
import com.sc.scbackend.SCInfrastructure.enums.TrashBinType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("trashbininfo")
public class TrashBinInfo extends BaseEntity {

    @TableId(value = "BinID")
    private String binId;

    @TableField(value = "BinType")
    private TrashBinType binType;

    @TableField(value = "LocationID")
    private Integer locationId;

    @TableField(value = "Capacity")
    private BigDecimal capacity;

    @TableField(value = "Status")
    private TrashBinStatus status;

    @TableField(value = "LastUpdate")
    private Timestamp lastUpdate;


}
