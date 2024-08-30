package com.sc.scbackend.controller;

import com.sc.scbackend.base.BaseResult;
import com.sc.scbackend.domain.RoadEnvironmentInspection;
import com.sc.scbackend.service.RoadEnvironmentInspectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sc/api/roadenvir")
public class RoadEnvironmentInspectionController {

    @Autowired
    private RoadEnvironmentInspectionService roadEnvironmentInspectionService;

    @PostMapping(path = "add", consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<BaseResult> addRoadEnvironmentInspection(@ModelAttribute RoadEnvironmentInspection roadEnvironmentInspection) {

        boolean res = roadEnvironmentInspectionService.save(roadEnvironmentInspection);
        if(res) {
            return ResponseEntity.ok().body(BaseResult.success("添加成功", roadEnvironmentInspection));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "delete", consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<BaseResult> deleteRoadEnvironmentInspection(@ModelAttribute RoadEnvironmentInspection roadEnvironmentInspection) {
        boolean res = roadEnvironmentInspectionService.removeById(roadEnvironmentInspection);

        if(res) {
            return ResponseEntity.ok().body(BaseResult.success("删除成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "update", consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<BaseResult> updateRoadEnvironmentInspection(@ModelAttribute RoadEnvironmentInspection roadEnvironmentInspection) {

        boolean res =  roadEnvironmentInspectionService.updateById(roadEnvironmentInspection);
        if(res) {
            return ResponseEntity.ok().body(BaseResult.success("修改成功", roadEnvironmentInspection));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }
}