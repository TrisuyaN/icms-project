package com.sc.scbackend.controller;

import com.sc.scbackend.base.BaseResult;
import com.sc.scbackend.domain.Vehicle;
import com.sc.scbackend.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sc/api/car")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping(path = "add", consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<BaseResult> addVehicle(@ModelAttribute Vehicle vehicle) {

        boolean res = vehicleService.save(vehicle);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("添加成功", vehicle));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "delete", consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<BaseResult> delete(@ModelAttribute Vehicle vehicle) {
        boolean res = vehicleService.removeById(vehicle);

        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("删除成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }
}
