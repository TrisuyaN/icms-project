package com.sc.scbackend.SCInfrastructure.dao;

import com.github.yulichang.base.MPJBaseMapper;
import com.sc.scbackend.SCInfrastructure.domain.TrashBinInfo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface TrashBinInfoDao extends MPJBaseMapper<TrashBinInfo> {

}
