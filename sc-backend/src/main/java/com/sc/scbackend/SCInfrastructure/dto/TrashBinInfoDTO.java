package com.sc.scbackend.SCInfrastructure.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.sc.scbackend.SCInfrastructure.enums.TrashBinStatus;
import com.sc.scbackend.SCInfrastructure.enums.TrashBinType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
public class TrashBinInfoDTO {

    // 前端不应修改
    private String binId;

    private TrashBinType binType;

    // 前端不应直接修改，通过 locationName 查询修改
    private Integer locationId;

    private BigDecimal capacity;

    private TrashBinStatus status;

    // 应自动生成
    private Timestamp lastUpdate;

    // 来自 `locationinfo` 表
    private String locationName;
}
