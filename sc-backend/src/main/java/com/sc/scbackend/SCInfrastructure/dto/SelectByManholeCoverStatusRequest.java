package com.sc.scbackend.SCInfrastructure.dto;

import com.sc.scbackend.SCInfrastructure.enums.ManholeCoverStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SelectByManholeCoverStatusRequest {
    private ManholeCoverStatus manholeCoverStatus;
}
