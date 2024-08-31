package com.sc.scbackend.SCPending.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.scbackend.SCPending.dao.ExtremeWeatherDao;
import com.sc.scbackend.SCPending.domain.ExtremeWeather;
import com.sc.scbackend.SCPending.service.ExtremeWeatherService;
import org.springframework.stereotype.Component;

@Component
public class ExtremeWeatherServiceImpl extends ServiceImpl<ExtremeWeatherDao, ExtremeWeather> implements ExtremeWeatherService {

}
