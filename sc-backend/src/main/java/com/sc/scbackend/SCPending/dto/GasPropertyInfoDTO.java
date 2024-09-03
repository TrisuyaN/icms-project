package com.sc.scbackend.SCPending.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.sc.scbackend.SCPending.enums.GasStatus;
import com.sc.scbackend.SCPending.enums.UrgencyLevel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class GasPropertyInfoDTO {

    private String gasId;

    private Integer propertyId;

    private BigDecimal concentration;

    private UrgencyLevel urgencyLevel;

    private GasStatus status;

    private Integer buildingNumber;

    private String unit;

    private Integer numberOfRooms;

    private Integer floorNumber;
}
