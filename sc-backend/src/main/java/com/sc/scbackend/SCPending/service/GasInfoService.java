package com.sc.scbackend.SCPending.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sc.scbackend.SCPending.domain.GasInfo;
import com.sc.scbackend.SCPending.dto.GasPropertyInfoDTO;
import com.sc.scbackend.SCPending.enums.GasStatus;
import com.sc.scbackend.SCPending.enums.UrgencyLevel;

import java.util.List;

public interface GasInfoService extends IService<GasInfo> {
    List<GasPropertyInfoDTO> getAllGasPropertyInfo();

    List<GasPropertyInfoDTO> getAllGasPropertyInfoByConditions(UrgencyLevel urgencyLevel, GasStatus status);
}
