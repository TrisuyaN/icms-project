package com.sc.scbackend.SCPending.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MemberElevatorEntryDTO {

    private String entryId;

    private Date entryTime;

    private String name;

    private String contactInfo;
}
