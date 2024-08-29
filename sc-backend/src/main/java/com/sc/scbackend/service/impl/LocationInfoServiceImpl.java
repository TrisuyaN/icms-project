package com.sc.scbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.scbackend.dao.LocationInfoDao;
import com.sc.scbackend.domain.LocationInfo;
import com.sc.scbackend.service.LocationInfoService;
import org.springframework.stereotype.Component;

@Component
public class LocationInfoServiceImpl extends ServiceImpl<LocationInfoDao, LocationInfo> implements LocationInfoService {

}
