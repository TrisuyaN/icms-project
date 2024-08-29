package com.sc.scbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.scbackend.dao.ElevatorEntryDao;
import com.sc.scbackend.domain.ElevatorEntry;
import com.sc.scbackend.service.ElevatorEntryService;
import org.springframework.stereotype.Component;

@Component
public class ElevatorEntryServiceImpl extends ServiceImpl<ElevatorEntryDao, ElevatorEntry> implements ElevatorEntryService {

}
