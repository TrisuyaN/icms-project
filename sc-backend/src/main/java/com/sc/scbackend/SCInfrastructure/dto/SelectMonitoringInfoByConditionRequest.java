package com.sc.scbackend.SCInfrastructure.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SelectMonitoringInfoByConditionRequest {
    private String id;
    private String locationName;
}
