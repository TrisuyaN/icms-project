package com.sc.scbackend.SCPending.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sc.scbackend.SCPending.domain.ElevatorEntry;
import com.sc.scbackend.SCPending.dto.MemberElevatorEntryDTO;

import java.util.List;

public interface ElevatorEntryService extends IService<ElevatorEntry> {
    List<MemberElevatorEntryDTO> getMemberElevatorEntryByMemberName(String memberName);

}
