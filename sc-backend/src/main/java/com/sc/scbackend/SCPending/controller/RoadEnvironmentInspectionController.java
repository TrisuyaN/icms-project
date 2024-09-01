package com.sc.scbackend.SCPending.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sc.scbackend.SCPending.domain.RoadEnvironmentInspection;
import com.sc.scbackend.SCPending.dto.SelectByRoadEnvStatusRequest;
import com.sc.scbackend.SCPending.dto.SelectVehicleOccupationRequest;
import com.sc.scbackend.SCPending.dto.VehicleOccupationDTO;
import com.sc.scbackend.SCPending.enums.RoadEnvironmentInspectionType;
import com.sc.scbackend.SCPending.service.RoadEnvironmentInspectionService;
import com.sc.scbackend.base.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sc/api/roadenvir")
public class RoadEnvironmentInspectionController {

    @Autowired
    private RoadEnvironmentInspectionService roadEnvironmentInspectionService;

    @PostMapping(path = "add")
    public ResponseEntity<BaseResult> addRoadEnvironmentInspection(@RequestBody RoadEnvironmentInspection roadEnvironmentInspection) {

        boolean res = roadEnvironmentInspectionService.save(roadEnvironmentInspection);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("添加成功", roadEnvironmentInspection));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "delete")
    public ResponseEntity<BaseResult> deleteRoadEnvironmentInspection(@RequestBody RoadEnvironmentInspection roadEnvironmentInspection) {
        boolean res = roadEnvironmentInspectionService.removeById(roadEnvironmentInspection);

        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("删除成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "update")
    public ResponseEntity<BaseResult> updateRoadEnvironmentInspection(@RequestBody RoadEnvironmentInspection roadEnvironmentInspection) {

        boolean res = roadEnvironmentInspectionService.updateById(roadEnvironmentInspection);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("修改成功", roadEnvironmentInspection));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "findall")
    public ResponseEntity<BaseResult> selectAllRoadEnvironmentInspection() {
        List<RoadEnvironmentInspection> res = roadEnvironmentInspectionService.list();
        if (res != null) {
            return ResponseEntity.ok().body(BaseResult.success("查询成功", res));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "car")
    public ResponseEntity<BaseResult> selectCarOccupation() {

        QueryWrapper<RoadEnvironmentInspection> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("InspectionType", RoadEnvironmentInspectionType.OBSTRUCTION_REMOVAL);

        List<RoadEnvironmentInspection> res = roadEnvironmentInspectionService.list(queryWrapper);
        if (res != null) {
            return ResponseEntity.ok().body(BaseResult.success("查询成功", res));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    // 需要联表组合查询
    @PostMapping(path = "carbycondition")
    public ResponseEntity<BaseResult> selectCarOccupationByCondition(@RequestBody SelectVehicleOccupationRequest selectVehicleOccupationRequest) {

        // TODO：非空检查
        List<VehicleOccupationDTO> res = roadEnvironmentInspectionService.getRoadEnvironmentInspection(
                selectVehicleOccupationRequest.getLicensePlate(),
                selectVehicleOccupationRequest.getRoadEnvironmentInspectionStatus());

        if (res != null) {
            return ResponseEntity.ok().body(BaseResult.success("查询成功", res));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "findbycondition")
    public ResponseEntity<BaseResult> selectByRoadEnvStatus(@RequestBody SelectByRoadEnvStatusRequest selectByRoadEnvStatusRequest) {

        QueryWrapper<RoadEnvironmentInspection> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("Status", selectByRoadEnvStatusRequest.getStatus());

        List<RoadEnvironmentInspection> res = roadEnvironmentInspectionService.list(queryWrapper);
        if (res != null) {
            return ResponseEntity.ok().body(BaseResult.success("查询成功", res));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

}