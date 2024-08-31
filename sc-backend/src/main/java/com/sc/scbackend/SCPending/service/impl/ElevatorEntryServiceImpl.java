package com.sc.scbackend.SCPending.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.scbackend.SCPending.dao.ElevatorEntryDao;
import com.sc.scbackend.SCPending.domain.ElevatorEntry;
import com.sc.scbackend.SCPending.service.ElevatorEntryService;
import org.springframework.stereotype.Component;

@Component
public class ElevatorEntryServiceImpl extends ServiceImpl<ElevatorEntryDao, ElevatorEntry> implements ElevatorEntryService {

}
