package com.sc.scbackend.SCPending.dto;

import com.sc.scbackend.SCPending.enums.GasStatus;
import com.sc.scbackend.SCPending.enums.UrgencyLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SelectGasInfoByConditionRequest {
    private GasStatus status;
    private UrgencyLevel urgencyLevel;
}
