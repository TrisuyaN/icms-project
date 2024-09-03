package com.sc.scbackend.SCPending.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.sc.scbackend.SCPending.dao.GasInfoDao;
import com.sc.scbackend.SCPending.domain.GasInfo;
import com.sc.scbackend.SCPending.dto.GasPropertyInfoDTO;
import com.sc.scbackend.SCPending.enums.GasStatus;
import com.sc.scbackend.SCPending.enums.UrgencyLevel;
import com.sc.scbackend.SCPending.service.GasInfoService;
import com.sc.scbackend.SCResident.domain.PropertyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GasInfoServiceImpl extends ServiceImpl<GasInfoDao, GasInfo> implements GasInfoService {

    @Autowired
    private GasInfoDao gasInfoDao;

    @Override
    public List<GasPropertyInfoDTO> getAllGasPropertyInfo() {
        MPJLambdaWrapper<GasInfo> wrapper = new MPJLambdaWrapper<>();
        wrapper.selectAll(GasInfo.class)
                .selectAll(PropertyInfo.class)
                .leftJoin(PropertyInfo.class, PropertyInfo::getId, GasInfo::getPropertyId);

        return gasInfoDao.selectJoinList(GasPropertyInfoDTO.class, wrapper);
    }

    @Override
    public List<GasPropertyInfoDTO> getAllGasPropertyInfoByConditions(UrgencyLevel urgencyLevel, GasStatus status) {
        MPJLambdaWrapper<GasInfo> wrapper = new MPJLambdaWrapper<>();
        wrapper.selectAll(GasInfo.class)
                .selectAll(PropertyInfo.class)
                .leftJoin(PropertyInfo.class, PropertyInfo::getId, GasInfo::getPropertyId);

        if(urgencyLevel != null) {
            wrapper.eq(GasInfo::getUrgencyLevel, urgencyLevel);
        }
        if(status != null) {
            wrapper.eq(GasInfo::getStatus, status);
        }

        return gasInfoDao.selectJoinList(GasPropertyInfoDTO.class, wrapper);
    }
}
