package com.sc.scbackend.SCResident.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.sc.scbackend.SCInfrastructure.domain.LocationInfo;
import com.sc.scbackend.SCInfrastructure.domain.TrashBinInfo;
import com.sc.scbackend.SCInfrastructure.dto.TrashBinInfoDTO;
import com.sc.scbackend.SCResident.dao.VehicleDao;
import com.sc.scbackend.SCResident.domain.Member;
import com.sc.scbackend.SCResident.domain.Vehicle;
import com.sc.scbackend.SCResident.dto.VehicleInfoDTO;
import com.sc.scbackend.SCResident.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

    @Override
    public List<VehicleInfoDTO> getAllVehicleInfo() {
        MPJLambdaWrapper<Vehicle> wrapper = new MPJLambdaWrapper<>();

        wrapper.selectAll(Vehicle.class)
                .selectAll(Member.class)
                .leftJoin(Member.class, Member::getId, Vehicle::getResidentId);

        return vehicleDao.selectJoinList(VehicleInfoDTO.class, wrapper);
    }
}
