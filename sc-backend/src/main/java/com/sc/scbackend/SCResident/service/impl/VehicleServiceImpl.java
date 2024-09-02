package com.sc.scbackend.SCResident.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.scbackend.SCResident.dao.VehicleDao;
import com.sc.scbackend.SCResident.domain.Vehicle;
import com.sc.scbackend.SCResident.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleServiceImpl extends ServiceImpl<VehicleDao, Vehicle> implements VehicleService {

    @Autowired
    private VehicleDao vehicleDao;


    @Override
    public void addVehicleInfo(String licensePlate, byte[] registrationPhoto, Integer residentId) {
        Vehicle vehicle = new Vehicle();
        vehicle.setLicensePlate(licensePlate);
        vehicle.setRegistrationPhoto(registrationPhoto);
        vehicle.setResidentId(residentId);
        vehicleDao.insert(vehicle);
    }
}
