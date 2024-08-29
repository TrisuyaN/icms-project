package com.sc.scbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.scbackend.dao.FireHydrantDao;
import com.sc.scbackend.domain.FireHydrant;
import com.sc.scbackend.service.FireHydrantService;
import org.springframework.stereotype.Component;

@Component
public class FireHydrantServiceImpl extends ServiceImpl<FireHydrantDao, FireHydrant> implements FireHydrantService {

}
