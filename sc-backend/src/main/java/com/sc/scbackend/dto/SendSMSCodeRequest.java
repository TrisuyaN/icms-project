package com.sc.scbackend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendSMSCodeRequest {
    private String phoneNumber;
}
