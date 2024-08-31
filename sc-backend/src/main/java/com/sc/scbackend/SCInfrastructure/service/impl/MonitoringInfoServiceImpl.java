package com.sc.scbackend.SCInfrastructure.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.scbackend.SCInfrastructure.dao.MonitoringInfoDao;
import com.sc.scbackend.SCInfrastructure.service.MonitoringInfoService;
import com.sc.scbackend.SCInfrastructure.domain.MonitoringInfo;
import org.springframework.stereotype.Component;

@Component
public class MonitoringInfoServiceImpl extends ServiceImpl<MonitoringInfoDao, MonitoringInfo> implements MonitoringInfoService {

}
