package com.sc.scbackend.SCPending.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.sc.scbackend.SCPending.dao.ElevatorEntryDao;
import com.sc.scbackend.SCPending.domain.ElevatorEntry;
import com.sc.scbackend.SCPending.dto.MemberElevatorEntryDTO;
import com.sc.scbackend.SCPending.service.ElevatorEntryService;
import com.sc.scbackend.SCResident.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ElevatorEntryServiceImpl extends ServiceImpl<ElevatorEntryDao, ElevatorEntry> implements ElevatorEntryService {

    @Autowired
    private ElevatorEntryDao elevatorEntryDao;

    @Override
    public List<MemberElevatorEntryDTO> getMemberElevatorEntryByMemberName(String memberName) {

        MPJLambdaWrapper<ElevatorEntry> wrapper = new MPJLambdaWrapper<>();
        wrapper.selectAll(ElevatorEntry.class)
                .selectAll(Member.class)
                .leftJoin(Member.class, Member::getId, ElevatorEntry::getMemberId);

        if(memberName != null) {
            wrapper.like(Member::getName, memberName);
        }

        List<MemberElevatorEntryDTO> res = elevatorEntryDao.selectJoinList(MemberElevatorEntryDTO.class, wrapper);

        return res;
    }
}
