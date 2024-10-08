package com.sc.scbackend.SCPending.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.sc.scbackend.SCPending.dao.RoadEnvironmentInspectionDao;
import com.sc.scbackend.SCPending.domain.RoadEnvironmentInspection;
import com.sc.scbackend.SCPending.dto.VehicleOccupationDTO;
import com.sc.scbackend.SCPending.enums.RoadEnvironmentInspectionStatus;
import com.sc.scbackend.SCPending.enums.RoadEnvironmentInspectionType;
import com.sc.scbackend.SCPending.service.RoadEnvironmentInspectionService;
import com.sc.scbackend.SCResident.domain.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoadEnvironmentInspectionServiceImpl extends ServiceImpl<RoadEnvironmentInspectionDao, RoadEnvironmentInspection> implements RoadEnvironmentInspectionService {

    @Autowired
    private RoadEnvironmentInspectionDao roadEnvironmentInspectionDao;

    public List<VehicleOccupationDTO> getVehicleOccupationDTO(String licensePlate, RoadEnvironmentInspectionStatus roadEnvironmentInspectionStatus) {

        MPJLambdaWrapper<RoadEnvironmentInspection> wrapper = new MPJLambdaWrapper<>();
        wrapper
                .selectAll(RoadEnvironmentInspection.class) // 选择 RoadEnvironmentInspection 表的所有字段
                .selectAll(Vehicle.class)                    // 选择 Vehicle 表的所有字段
//                .leftJoin(Vehicle.class, Vehicle::getLicensePlate, RoadEnvironmentInspection::getCarId);
                .leftJoin(Vehicle.class, Vehicle::getId, RoadEnvironmentInspection::getCarId) // 左连接，连接字段为id（int）而非车牌！
                .eq(RoadEnvironmentInspection::getInspectionType, RoadEnvironmentInspectionType.CAR_OBSTRUCTION); // 查询车辆占道类型
        if (licensePlate != null) {
            wrapper.like(Vehicle::getLicensePlate, licensePlate); // 根据车牌号筛选
        }
        if (roadEnvironmentInspectionStatus != null) {
            wrapper.eq(RoadEnvironmentInspection::getInspectionStatus, roadEnvironmentInspectionStatus); // 根据状态筛选
        }

        List<VehicleOccupationDTO> res = roadEnvironmentInspectionDao.selectJoinList(VehicleOccupationDTO.class, wrapper);

        return res; // 返回结果
    }

//    @Override
//    public List<RoadEnvironmentInspection> getVehicleOccupationDTO(String licensePlate, RoadEnvironmentInspectionStatus roadEnvironmentInspectionStatus) {
//
//        MPJLambdaWrapper<RoadEnvironmentInspection> wrapper = new MPJLambdaWrapper<>();
//        wrapper
//                .selectAll(RoadEnvironmentInspection.class)
//                .eq(RoadEnvironmentInspection::getInspectionType, RoadEnvironmentInspectionType.CAR_OBSTRUCTION);
//        if (licensePlate != null) {
//            wrapper.like(Vehicle::getLicensePlate, licensePlate);
//        }
//        if (roadEnvironmentInspectionStatus != null) {
//            wrapper.eq(RoadEnvironmentInspection::getInspectionStatus, roadEnvironmentInspectionStatus); // 根据状态筛选
//        }
//
//        List<RoadEnvironmentInspection> res = roadEnvironmentInspectionDao.selectJoinList(RoadEnvironmentInspection.class, wrapper);
//
//        return res; // 返回结果
//    }
}
