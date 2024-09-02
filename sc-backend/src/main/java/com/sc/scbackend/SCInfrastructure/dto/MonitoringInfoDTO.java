package com.sc.scbackend.SCInfrastructure.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MonitoringInfoDTO {
    private Integer id;

    private String video;

    private Integer pointId;

    private String locationName;
}
