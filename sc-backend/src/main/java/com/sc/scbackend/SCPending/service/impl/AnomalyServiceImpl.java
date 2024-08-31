package com.sc.scbackend.SCPending.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.scbackend.SCPending.dao.AnomalyDao;
import com.sc.scbackend.SCPending.domain.Anomaly;
import com.sc.scbackend.SCPending.service.AnomalyService;
import org.springframework.stereotype.Component;

@Component
public class AnomalyServiceImpl extends ServiceImpl<AnomalyDao, Anomaly> implements AnomalyService {

}
