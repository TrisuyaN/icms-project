package com.sc.scbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.scbackend.dao.TrashBinInfoDao;
import com.sc.scbackend.domain.TrashBinInfo;
import com.sc.scbackend.service.TrashBinInfoService;
import org.springframework.stereotype.Component;

@Component
public class TrashBinInfoServiceImpl extends ServiceImpl<TrashBinInfoDao, TrashBinInfo> implements TrashBinInfoService {

}
