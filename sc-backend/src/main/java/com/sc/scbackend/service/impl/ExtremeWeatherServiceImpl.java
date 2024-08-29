package com.sc.scbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.scbackend.dao.ExtremeWeatherDao;
import com.sc.scbackend.domain.ExtremeWeather;
import com.sc.scbackend.service.ExtremeWeatherService;
import org.springframework.stereotype.Component;

@Component
public class ExtremeWeatherServiceImpl extends ServiceImpl<ExtremeWeatherDao, ExtremeWeather> implements ExtremeWeatherService {

}
