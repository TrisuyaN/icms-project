package com.sc.scbackend.SCPending.dto;

import com.sc.scbackend.SCPending.enums.GreenEnvironmentStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SelectGreenEnvironmentInfoByStatusRequest {
    private GreenEnvironmentStatus status;
}
