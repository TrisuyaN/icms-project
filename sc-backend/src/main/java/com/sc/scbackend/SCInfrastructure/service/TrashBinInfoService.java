package com.sc.scbackend.SCInfrastructure.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sc.scbackend.SCInfrastructure.domain.TrashBinInfo;
import com.sc.scbackend.SCInfrastructure.dto.TrashBinInfoDTO;

import java.io.Serializable;
import java.util.List;

public interface TrashBinInfoService extends IService<TrashBinInfo> {
    List<TrashBinInfoDTO> getAllTrashBinInfo();

    TrashBinInfoDTO getTrashBinInfoById(Serializable id);

    String updateTrashBinInfo(TrashBinInfoDTO trashBinInfoDTO);

    String addTrashBinInfo(TrashBinInfoDTO trashBinInfoDTO);

}
