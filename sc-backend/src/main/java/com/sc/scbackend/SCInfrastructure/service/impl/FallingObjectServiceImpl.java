package com.sc.scbackend.SCInfrastructure.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.scbackend.SCPending.dao.FallingObjectDao;
import com.sc.scbackend.SCPending.domain.FallingObject;
import com.sc.scbackend.SCPending.service.FallingObjectService;
import org.springframework.stereotype.Component;

@Component
public class FallingObjectServiceImpl extends ServiceImpl<FallingObjectDao, FallingObject> implements FallingObjectService {

}
