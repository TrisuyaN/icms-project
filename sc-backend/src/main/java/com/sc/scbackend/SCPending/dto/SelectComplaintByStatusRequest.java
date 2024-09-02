package com.sc.scbackend.SCPending.dto;

import com.sc.scbackend.SCPending.enums.ComplaintStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SelectComplaintByStatusRequest {
    private ComplaintStatus status;
}
