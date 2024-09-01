package com.sc.scbackend.SCPending.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.sc.scbackend.SCPending.dao.FallingObjectDao;
import com.sc.scbackend.SCPending.domain.FallingObject;
import com.sc.scbackend.SCPending.dto.FallingObjectIncidentDTO;
import com.sc.scbackend.SCPending.enums.FallingObjectStatus;
import com.sc.scbackend.SCPending.service.FallingObjectService;
import com.sc.scbackend.SCResident.domain.PropertyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FallingObjectServiceImpl extends ServiceImpl<FallingObjectDao, FallingObject> implements FallingObjectService {

    @Autowired
    private FallingObjectDao fallingObjectDao;

    @Override
    public List<FallingObjectIncidentDTO> getFallingObjectIncident(FallingObjectStatus fallingObjectStatus, String memberName) {

        MPJLambdaWrapper<FallingObject> wrapper = new MPJLambdaWrapper<>();

        wrapper.selectAll(FallingObject.class)
                .selectAll(PropertyInfo.class)
                .leftJoin(PropertyInfo.class, PropertyInfo::getId, FallingObject::getPropertyId);

        if(fallingObjectStatus != null) {
            wrapper.eq(FallingObject::getStatus, fallingObjectStatus);
        }
        if(memberName != null) {
            wrapper.like(PropertyInfo::getOwnerName, memberName);
        }

        List<FallingObjectIncidentDTO> res = fallingObjectDao.selectJoinList(FallingObjectIncidentDTO.class, wrapper);

        return res;
    }
}
