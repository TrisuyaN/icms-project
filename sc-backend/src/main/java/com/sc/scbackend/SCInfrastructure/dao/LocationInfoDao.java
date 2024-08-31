package com.sc.scbackend.SCInfrastructure.dao;

import com.github.yulichang.base.MPJBaseMapper;
import com.sc.scbackend.SCInfrastructure.domain.LocationInfo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface LocationInfoDao extends MPJBaseMapper<LocationInfo> {

}
