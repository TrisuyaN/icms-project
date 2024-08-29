package com.sc.scbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.scbackend.dao.FallingObjectDao;
import com.sc.scbackend.domain.FallingObject;
import com.sc.scbackend.service.FallingObjectService;
import org.springframework.stereotype.Component;

@Component
public class FallingObjectServiceImpl extends ServiceImpl<FallingObjectDao, FallingObject> implements FallingObjectService {

}
