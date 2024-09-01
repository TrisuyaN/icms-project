package com.sc.scbackend.SCPending.dto;

import com.sc.scbackend.SCPending.enums.RoadEnvironmentInspectionStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SelectVehicleOccupationRequest {
    private String licensePlate;
    private RoadEnvironmentInspectionStatus roadEnvironmentInspectionStatus;
}
