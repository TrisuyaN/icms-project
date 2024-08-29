package com.sc.scbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.scbackend.dao.PropertyInfoDao;
import com.sc.scbackend.domain.PropertyInfo;
import com.sc.scbackend.service.PropertyInfoService;
import org.springframework.stereotype.Component;

@Component
public class PropertyInfoServiceImpl extends ServiceImpl<PropertyInfoDao, PropertyInfo> implements PropertyInfoService {

}
