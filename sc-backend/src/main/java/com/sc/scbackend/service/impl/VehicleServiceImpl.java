package com.sc.scbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.scbackend.dao.VehicleDao;
import com.sc.scbackend.domain.Vehicle;
import com.sc.scbackend.service.VehicleService;
import org.springframework.stereotype.Component;

@Component
public class VehicleServiceImpl extends ServiceImpl<VehicleDao, Vehicle> implements VehicleService {

}
