package com.sc.scbackend.SCResident.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.scbackend.SCResident.dao.PropertyInfoDao;
import com.sc.scbackend.SCResident.domain.PropertyInfo;
import com.sc.scbackend.SCResident.service.PropertyInfoService;
import org.springframework.stereotype.Component;

@Component
public class PropertyInfoServiceImpl extends ServiceImpl<PropertyInfoDao, PropertyInfo> implements PropertyInfoService {

}
