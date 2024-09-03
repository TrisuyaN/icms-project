package com.sc.scbackend.SCInfrastructure.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.sc.scbackend.SCInfrastructure.dao.LocationInfoDao;
import com.sc.scbackend.SCInfrastructure.dao.TrashBinInfoDao;
import com.sc.scbackend.SCInfrastructure.domain.LocationInfo;
import com.sc.scbackend.SCInfrastructure.dto.TrashBinInfoDTO;
import com.sc.scbackend.SCInfrastructure.service.LocationInfoService;
import com.sc.scbackend.SCInfrastructure.service.TrashBinInfoService;
import com.sc.scbackend.SCInfrastructure.domain.TrashBinInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import static java.lang.System.currentTimeMillis;

@Component
public class TrashBinInfoServiceImpl extends ServiceImpl<TrashBinInfoDao, TrashBinInfo> implements TrashBinInfoService {

    @Autowired
    TrashBinInfoDao trashBinInfoDao;

    @Autowired
    LocationInfoDao locationInfoDao;

    @Override
    public List<TrashBinInfoDTO> getAllTrashBinInfo() {
        MPJLambdaWrapper<TrashBinInfo> wrapper = new MPJLambdaWrapper<>();

        wrapper.selectAll(TrashBinInfo.class)
                .selectAll(LocationInfo.class)
                .leftJoin(LocationInfo.class, LocationInfo::getPointId, TrashBinInfo::getLocationId);

        List<TrashBinInfoDTO> res = trashBinInfoDao.selectJoinList(TrashBinInfoDTO.class, wrapper);

        return res;
    }

    @Override
    public TrashBinInfoDTO getTrashBinInfoById(Serializable id) {
        MPJLambdaWrapper<TrashBinInfo> wrapper = new MPJLambdaWrapper<>();

        wrapper.selectAll(TrashBinInfo.class)
                .selectAll(LocationInfo.class)
                .leftJoin(LocationInfo.class, LocationInfo::getPointId, TrashBinInfo::getLocationId)
                .eq(TrashBinInfo::getBinId, id);

        TrashBinInfoDTO res = trashBinInfoDao.selectJoinOne(TrashBinInfoDTO.class, wrapper);

        return res;
    }

    @Override
    public String updateTrashBinInfo(TrashBinInfoDTO trashBinInfoDTO) {
        String message = null;

        TrashBinInfo ori = trashBinInfoDao.selectById(trashBinInfoDTO.getBinId());
        ori.setLastUpdate(new Timestamp(currentTimeMillis()));
        if(trashBinInfoDTO.getBinType()!=null) {
            ori.setBinType(trashBinInfoDTO.getBinType());
        }
        if(trashBinInfoDTO.getCapacity()!=null) {
            ori.setCapacity(trashBinInfoDTO.getCapacity());
        }
        if(trashBinInfoDTO.getStatus() != null) {
            ori.setStatus(trashBinInfoDTO.getStatus());
        }
        if(trashBinInfoDTO.getLocationName() != null) {
            LocationInfo locationInfo = locationInfoDao.getByLocationName(trashBinInfoDTO.getLocationName());
            if(locationInfo!=null) {
                ori.setLocationId(locationInfo.getPointId());
            }
            else {
                return "位置不存在";
            }
        }

        trashBinInfoDao.updateById(ori);

        return message;
    }

    @Override
    public String addTrashBinInfo(TrashBinInfoDTO trashBinInfoDTO) {
        String message = null;

        TrashBinInfo newTrashBinInfo = new TrashBinInfo();

        newTrashBinInfo.setBinType(trashBinInfoDTO.getBinType());
        newTrashBinInfo.setCapacity(trashBinInfoDTO.getCapacity());
        newTrashBinInfo.setStatus(trashBinInfoDTO.getStatus());
        newTrashBinInfo.setLastUpdate(new Timestamp(currentTimeMillis()));

        if(trashBinInfoDTO.getLocationName() != null) {
            LocationInfo locationInfo = locationInfoDao.getByLocationName(trashBinInfoDTO.getLocationName());
            if(locationInfo!=null) {
                newTrashBinInfo.setLocationId(locationInfo.getPointId());
            }
            else {
                return "位置不存在";
            }
        }

        trashBinInfoDao.insert(newTrashBinInfo);

        return message;
    }
}
