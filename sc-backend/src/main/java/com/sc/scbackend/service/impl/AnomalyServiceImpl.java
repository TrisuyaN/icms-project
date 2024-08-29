package com.sc.scbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.scbackend.dao.AnomalyDao;
import com.sc.scbackend.domain.Anomaly;
import com.sc.scbackend.service.AnomalyService;
import org.springframework.stereotype.Component;

@Component
public class AnomalyServiceImpl extends ServiceImpl<AnomalyDao, Anomaly> implements AnomalyService {

}
