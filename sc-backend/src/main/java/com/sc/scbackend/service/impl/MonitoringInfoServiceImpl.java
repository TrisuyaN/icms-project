package com.sc.scbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.scbackend.dao.MonitoringInfoDao;
import com.sc.scbackend.domain.MonitoringInfo;
import com.sc.scbackend.service.MonitoringInfoService;
import org.springframework.stereotype.Component;

@Component
public class MonitoringInfoServiceImpl extends ServiceImpl<MonitoringInfoDao, MonitoringInfo> implements MonitoringInfoService {

}
