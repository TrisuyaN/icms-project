package com.sc.scbackend.SCPending.dto;

import com.sc.scbackend.SCPending.enums.SuspiciousStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SelectSuspiciousInfoByStatusRequest {
    private SuspiciousStatus status;
}
