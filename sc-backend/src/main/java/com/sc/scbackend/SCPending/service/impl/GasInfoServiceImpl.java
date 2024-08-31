package com.sc.scbackend.SCPending.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.scbackend.SCPending.dao.GasInfoDao;
import com.sc.scbackend.SCPending.domain.GasInfo;
import com.sc.scbackend.SCPending.service.GasInfoService;
import org.springframework.stereotype.Component;

@Component
public class GasInfoServiceImpl extends ServiceImpl<GasInfoDao, GasInfo> implements GasInfoService {

}
