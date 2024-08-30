package com.sc.scbackend.controller;

import com.sc.scbackend.base.BaseResult;
import com.sc.scbackend.domain.LocationInfo;
import com.sc.scbackend.service.LocationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sc/api/locationinfo")
public class LocationInfoController {

    @Autowired
    private LocationInfoService locationInfoService;

    @PostMapping(path = "add", consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<BaseResult> addLocationInfo(@ModelAttribute LocationInfo locationInfo) {

        boolean res = locationInfoService.save(locationInfo);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("添加成功", locationInfo));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "delete", consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<BaseResult> deleteLocationInfo(@ModelAttribute LocationInfo locationInfo) {
        boolean res = locationInfoService.removeById(locationInfo);

        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("删除成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "update", consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<BaseResult> updateLocationInfo(@ModelAttribute LocationInfo locationInfo) {

        boolean res = locationInfoService.updateById(locationInfo);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("修改成功", locationInfo));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }
}