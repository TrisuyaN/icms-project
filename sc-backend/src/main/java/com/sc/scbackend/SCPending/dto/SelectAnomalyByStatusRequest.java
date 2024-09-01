package com.sc.scbackend.SCPending.dto;

import com.sc.scbackend.SCPending.enums.ProcessingStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SelectAnomalyByStatusRequest {
    private ProcessingStatus status;
}
