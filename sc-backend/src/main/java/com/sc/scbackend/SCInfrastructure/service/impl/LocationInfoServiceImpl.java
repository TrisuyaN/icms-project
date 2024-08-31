package com.sc.scbackend.SCInfrastructure.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.scbackend.SCInfrastructure.dao.LocationInfoDao;
import com.sc.scbackend.SCInfrastructure.service.LocationInfoService;
import com.sc.scbackend.SCInfrastructure.domain.LocationInfo;
import org.springframework.stereotype.Component;

@Component
public class LocationInfoServiceImpl extends ServiceImpl<LocationInfoDao, LocationInfo> implements LocationInfoService {

}
