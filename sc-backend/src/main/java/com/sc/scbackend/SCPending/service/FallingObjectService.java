package com.sc.scbackend.SCPending.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sc.scbackend.SCPending.domain.FallingObject;
import com.sc.scbackend.SCPending.dto.FallingObjectIncidentDTO;
import com.sc.scbackend.SCPending.enums.FallingObjectStatus;

import java.util.List;

public interface FallingObjectService extends IService<FallingObject> {
    List<FallingObjectIncidentDTO> getFallingObjectIncident(FallingObjectStatus fallingObjectStatus, String memberName);
}
