package com.sc.scbackend.SCInfrastructure.dao;

import com.github.yulichang.base.MPJBaseMapper;
import com.sc.scbackend.SCInfrastructure.domain.LocationInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface LocationInfoDao extends MPJBaseMapper<LocationInfo> {

    @Select("select * from locationinfo where LocationName = #{locationName}")
    LocationInfo getByLocationName(@Param("locationName") String locationName);
}
