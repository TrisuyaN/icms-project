package com.sc.scbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.scbackend.dao.TrashBinViolationDao;
import com.sc.scbackend.domain.TrashBinViolation;
import com.sc.scbackend.service.TrashBinViolationService;
import org.springframework.stereotype.Component;

@Component
public class TrashBinViolationServiceImpl extends ServiceImpl<TrashBinViolationDao, TrashBinViolation> implements TrashBinViolationService {

}
