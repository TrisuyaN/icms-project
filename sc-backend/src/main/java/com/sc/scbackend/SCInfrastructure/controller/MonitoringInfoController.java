package com.sc.scbackend.SCInfrastructure.controller;

import com.sc.scbackend.base.BaseResult;
import com.sc.scbackend.SCInfrastructure.domain.MonitoringInfo;
import com.sc.scbackend.SCInfrastructure.service.MonitoringInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sc/api/monitor")
public class MonitoringInfoController {

    @Autowired
    private MonitoringInfoService monitoringInfoService;

    @PostMapping(path = "add")
    public ResponseEntity<BaseResult> addMonitoringInfo(@RequestBody MonitoringInfo monitoringInfo) {

        boolean res = monitoringInfoService.save(monitoringInfo);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("添加成功", monitoringInfo));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "delete")
    public ResponseEntity<BaseResult> deleteMonitoringInfo(@RequestBody MonitoringInfo monitoringInfo) {
        boolean res = monitoringInfoService.removeById(monitoringInfo);

        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("删除成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "update")
    public ResponseEntity<BaseResult> updateMonitoringInfo(@RequestBody MonitoringInfo monitoringInfo) {

        boolean res = monitoringInfoService.updateById(monitoringInfo);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("修改成功", monitoringInfo));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }
}