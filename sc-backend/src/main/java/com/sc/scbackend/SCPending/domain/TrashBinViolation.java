package com.sc.scbackend.SCPending.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sc.scbackend.base.BaseEntity;
import com.sc.scbackend.SCPending.enums.TrashBinViolationType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("trashbinviolations")
public class TrashBinViolation extends BaseEntity {

    @TableId(value = "ViolationID")
    private Integer violationId;

    @TableField(value = "BinID")
    private String binId;

    @TableField(value = "ViolatorID")
    private Integer violatorId;

    @TableField(value = "ViolationType")
    private TrashBinViolationType violationType;

    @TableField(value = "ViolationDate")
    private Timestamp violationDate;

}
