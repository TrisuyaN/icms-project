package com.sc.scbackend.SCResident.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SelectMemberPropertyInfoByConditionRequest {
    private String name;

    private Integer buildingNumber;

    private String unit;

    private Integer floorNumber;

    private String roomNumber;

}
