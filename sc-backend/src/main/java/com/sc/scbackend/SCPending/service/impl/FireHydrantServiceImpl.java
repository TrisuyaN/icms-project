package com.sc.scbackend.SCPending.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.scbackend.SCInfrastructure.dao.FireHydrantDao;
import com.sc.scbackend.SCInfrastructure.domain.FireHydrant;
import com.sc.scbackend.SCInfrastructure.service.FireHydrantService;
import org.springframework.stereotype.Component;

@Component
public class FireHydrantServiceImpl extends ServiceImpl<FireHydrantDao, FireHydrant> implements FireHydrantService {

}
