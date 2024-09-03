package com.sc.scbackend.SCPending.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.sc.scbackend.SCPending.enums.RoadEnvironmentInspectionStatus;
import com.sc.scbackend.SCPending.enums.RoadEnvironmentInspectionType;
import com.sc.scbackend.SCPending.enums.TrashBinViolationType;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class VehicleOccupationDTO {

    private String id;

    private Integer pointId;

    private RoadEnvironmentInspectionType inspectionType;

    private RoadEnvironmentInspectionStatus inspectionStatus;

    private Integer carId;

    private String licensePlate;

    private byte[] registrationPhoto;

    private Integer residentId;
}
