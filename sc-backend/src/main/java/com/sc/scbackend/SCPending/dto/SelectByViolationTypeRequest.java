package com.sc.scbackend.SCPending.dto;

import com.sc.scbackend.SCPending.enums.TrashBinViolationType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SelectByViolationTypeRequest {
    private TrashBinViolationType trashBinViolationType;
}
