package com.sc.scbackend.SCResident.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sc.scbackend.SCResident.domain.Vehicle;
import com.sc.scbackend.SCResident.dto.VehicleInfoDTO;

import java.util.List;

public interface VehicleService extends IService<Vehicle> {
    void addVehicleInfo(
            String licensePlate,
            byte[] registrationPhoto,
            Integer residentId);

    List<VehicleInfoDTO> getAllVehicleInfo();
}
