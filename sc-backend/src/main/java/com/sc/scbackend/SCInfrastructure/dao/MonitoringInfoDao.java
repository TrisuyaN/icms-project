package com.sc.scbackend.SCInfrastructure.dao;

import com.github.yulichang.base.MPJBaseMapper;
import com.sc.scbackend.SCInfrastructure.domain.MonitoringInfo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface MonitoringInfoDao extends MPJBaseMapper<MonitoringInfo> {

}
