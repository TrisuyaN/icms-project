package com.sc.scbackend.SCPending.dto;

import com.sc.scbackend.SCPending.enums.RoadEnvironmentInspectionType;
import com.sc.scbackend.SCPending.enums.TrashBinViolationType;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class VehicleOccupationDTO {

    private String id;

    private Integer carId;

    private String licensePlate;

    private byte[] registrationPhoto;

    private Integer residentId;
}
