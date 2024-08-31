package com.sc.scbackend.SCPending.controller;

import com.sc.scbackend.base.BaseResult;
import com.sc.scbackend.SCPending.domain.ExtremeWeather;
import com.sc.scbackend.SCPending.service.ExtremeWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sc/api/extremeweather")
public class ExtremeWeatherController {

    @Autowired
    private ExtremeWeatherService extremeWeatherService;

    @PostMapping(path = "add")
    public ResponseEntity<BaseResult> addExtremeWeather(@RequestBody ExtremeWeather extremeWeather) {

        boolean res = extremeWeatherService.save(extremeWeather);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("添加成功", extremeWeather));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "delete")
    public ResponseEntity<BaseResult> deleteExtremeWeather(@RequestBody ExtremeWeather extremeWeather) {
        boolean res = extremeWeatherService.removeById(extremeWeather);

        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("删除成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "update")
    public ResponseEntity<BaseResult> updateExtremeWeather(@RequestBody ExtremeWeather extremeWeather) {

        boolean res = extremeWeatherService.updateById(extremeWeather);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("修改成功", extremeWeather));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }
}