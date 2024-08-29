package com.sc.scbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.scbackend.dao.GasInfoDao;
import com.sc.scbackend.domain.GasInfo;
import com.sc.scbackend.service.GasInfoService;
import org.springframework.stereotype.Component;

@Component
public class GasInfoServiceImpl extends ServiceImpl<GasInfoDao, GasInfo> implements GasInfoService {

}
