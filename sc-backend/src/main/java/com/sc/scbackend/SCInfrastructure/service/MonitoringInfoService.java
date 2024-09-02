package com.sc.scbackend.SCInfrastructure.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sc.scbackend.SCInfrastructure.domain.MonitoringInfo;
import com.sc.scbackend.SCInfrastructure.dto.MonitoringInfoDTO;

import java.util.List;

public interface MonitoringInfoService extends IService<MonitoringInfo> {
    List<MonitoringInfoDTO> getMonitoringInfoByIdOrLocationName(String id, String locationName);
}
