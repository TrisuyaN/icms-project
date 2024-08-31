package com.sc.scbackend.SCResident.dao;

import com.github.yulichang.base.MPJBaseMapper;
import com.sc.scbackend.SCResident.domain.Vehicle;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface VehicleDao extends MPJBaseMapper<Vehicle> {

}
