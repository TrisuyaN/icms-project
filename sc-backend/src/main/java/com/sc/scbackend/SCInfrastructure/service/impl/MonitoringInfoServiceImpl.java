package com.sc.scbackend.SCInfrastructure.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.sc.scbackend.SCInfrastructure.dao.MonitoringInfoDao;
import com.sc.scbackend.SCInfrastructure.domain.LocationInfo;
import com.sc.scbackend.SCInfrastructure.domain.MonitoringInfo;
import com.sc.scbackend.SCInfrastructure.dto.MonitoringInfoDTO;
import com.sc.scbackend.SCInfrastructure.service.MonitoringInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MonitoringInfoServiceImpl extends ServiceImpl<MonitoringInfoDao, MonitoringInfo> implements MonitoringInfoService {

    @Autowired
    MonitoringInfoDao monitoringInfoDao;

    @Override
    public List<MonitoringInfoDTO> getMonitoringInfoByIdOrLocationName(String pointId, String locationName) {
        MPJLambdaWrapper<MonitoringInfo> wrapper = new MPJLambdaWrapper<>();

        wrapper.selectAll(MonitoringInfo.class)
                .selectAll(LocationInfo.class)
                .leftJoin(LocationInfo.class, LocationInfo::getPointId, MonitoringInfo::getPointId);
        if (pointId != null) {
            wrapper.eq(MonitoringInfo::getPointId, pointId);
        }
        if (locationName != null) {
            wrapper.like(LocationInfo::getLocationName, locationName);
        }

        List<MonitoringInfoDTO> res = monitoringInfoDao.selectJoinList(MonitoringInfoDTO.class, wrapper);

        return res;
    }
}
