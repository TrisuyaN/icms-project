package com.sc.scbackend.SCResident.controller;

import com.sc.scbackend.base.BaseResult;
import com.sc.scbackend.SCResident.domain.Vehicle;
import com.sc.scbackend.SCResident.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sc/api/car")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping(path = "add")
    public ResponseEntity<BaseResult> addVehicle(@RequestBody Vehicle vehicle) {

        boolean res = vehicleService.save(vehicle);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("添加成功", vehicle));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "delete")
    public ResponseEntity<BaseResult> delete(@RequestBody Vehicle vehicle) {
        boolean res = vehicleService.removeById(vehicle);

        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("删除成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }
}
