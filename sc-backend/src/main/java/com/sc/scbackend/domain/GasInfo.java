package com.sc.scbackend.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sc.scbackend.enums.UrgencyLevel;
import com.sc.scbackend.enums.GasStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("gasinfo")
public class GasInfo {

    @TableId(value = "GasID")
    private String gasId;

    @TableField(value = "PropertyID")
    private Integer propertyId;

    @TableField(value = "Concentration")
    private BigDecimal concentration;

    @TableField(value = "UrgencyLevel")
    private UrgencyLevel urgencyLevel;

    @TableField(value = "Status")
    private GasStatus status;

}
