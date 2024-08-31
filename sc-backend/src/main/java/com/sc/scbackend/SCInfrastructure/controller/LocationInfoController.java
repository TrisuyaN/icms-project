package com.sc.scbackend.SCInfrastructure.controller;

import com.sc.scbackend.base.BaseResult;
import com.sc.scbackend.SCInfrastructure.domain.LocationInfo;
import com.sc.scbackend.SCInfrastructure.service.LocationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sc/api/locationinfo")
public class LocationInfoController {

    @Autowired
    private LocationInfoService locationInfoService;

    @PostMapping(path = "add")
    public ResponseEntity<BaseResult> addLocationInfo(@RequestBody LocationInfo locationInfo) {

        boolean res = locationInfoService.save(locationInfo);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("添加成功", locationInfo));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "delete")
    public ResponseEntity<BaseResult> deleteLocationInfo(@RequestBody LocationInfo locationInfo) {
        boolean res = locationInfoService.removeById(locationInfo);

        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("删除成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "update")
    public ResponseEntity<BaseResult> updateLocationInfo(@RequestBody LocationInfo locationInfo) {

        boolean res = locationInfoService.updateById(locationInfo);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("修改成功", locationInfo));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }
}