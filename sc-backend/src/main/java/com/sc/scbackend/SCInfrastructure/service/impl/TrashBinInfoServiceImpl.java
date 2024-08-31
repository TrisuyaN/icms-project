package com.sc.scbackend.SCInfrastructure.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.scbackend.SCInfrastructure.dao.TrashBinInfoDao;
import com.sc.scbackend.SCInfrastructure.service.TrashBinInfoService;
import com.sc.scbackend.SCInfrastructure.domain.TrashBinInfo;
import org.springframework.stereotype.Component;

@Component
public class TrashBinInfoServiceImpl extends ServiceImpl<TrashBinInfoDao, TrashBinInfo> implements TrashBinInfoService {

}
