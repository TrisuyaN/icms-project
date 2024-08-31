package com.sc.scbackend.SCPending.controller;

import com.sc.scbackend.base.BaseResult;
import com.sc.scbackend.SCPending.domain.RoadEnvironmentInspection;
import com.sc.scbackend.SCPending.service.RoadEnvironmentInspectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sc/api/roadenvir")
public class RoadEnvironmentInspectionController {

    @Autowired
    private RoadEnvironmentInspectionService roadEnvironmentInspectionService;

    @PostMapping(path = "add")
    public ResponseEntity<BaseResult> addRoadEnvironmentInspection(@RequestBody RoadEnvironmentInspection roadEnvironmentInspection) {

        boolean res = roadEnvironmentInspectionService.save(roadEnvironmentInspection);
        if(res) {
            return ResponseEntity.ok().body(BaseResult.success("添加成功", roadEnvironmentInspection));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "delete")
    public ResponseEntity<BaseResult> deleteRoadEnvironmentInspection(@RequestBody RoadEnvironmentInspection roadEnvironmentInspection) {
        boolean res = roadEnvironmentInspectionService.removeById(roadEnvironmentInspection);

        if(res) {
            return ResponseEntity.ok().body(BaseResult.success("删除成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "update")
    public ResponseEntity<BaseResult> updateRoadEnvironmentInspection(@RequestBody RoadEnvironmentInspection roadEnvironmentInspection) {

        boolean res =  roadEnvironmentInspectionService.updateById(roadEnvironmentInspection);
        if(res) {
            return ResponseEntity.ok().body(BaseResult.success("修改成功", roadEnvironmentInspection));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }
}