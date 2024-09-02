package com.sc.scbackend.SCPending.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sc.scbackend.SCPending.domain.RoadEnvironmentInspection;
import com.sc.scbackend.SCPending.dto.VehicleOccupationDTO;
import com.sc.scbackend.SCPending.enums.RoadEnvironmentInspectionStatus;

import java.util.List;

public interface RoadEnvironmentInspectionService extends IService<RoadEnvironmentInspection> {

    List<VehicleOccupationDTO> getRoadEnvironmentInspection(String licensePlate, RoadEnvironmentInspectionStatus roadEnvironmentInspectionStatus);
}
