package com.sc.scbackend.controller;

import com.sc.scbackend.base.BaseResult;
import com.sc.scbackend.domain.ExtremeWeather;
import com.sc.scbackend.service.ExtremeWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sc/api/extremeweather")
public class ExtremeWeatherController {

    @Autowired
    private ExtremeWeatherService extremeWeatherService;

    @PostMapping(path = "add")
    public ResponseEntity<BaseResult> addExtremeWeather(@ModelAttribute ExtremeWeather extremeWeather) {

        boolean res = extremeWeatherService.save(extremeWeather);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("添加成功", extremeWeather));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "delete")
    public ResponseEntity<BaseResult> deleteExtremeWeather(@ModelAttribute ExtremeWeather extremeWeather) {
        boolean res = extremeWeatherService.removeById(extremeWeather);

        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("删除成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "update")
    public ResponseEntity<BaseResult> updateExtremeWeather(@ModelAttribute ExtremeWeather extremeWeather) {

        boolean res = extremeWeatherService.updateById(extremeWeather);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("修改成功", extremeWeather));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }
}