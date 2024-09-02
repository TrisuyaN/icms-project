package com.sc.scbackend.SCPending.dto;

import com.sc.scbackend.SCPending.enums.FallingObjectStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SelectFallingObjectIncidentByConditionRequest {
    private FallingObjectStatus fallingObjectStatus;
    private String memberName;
}
