package com.sc.scbackend.controller;

import com.sc.scbackend.base.BaseResult;
import com.sc.scbackend.domain.MonitoringInfo;
import com.sc.scbackend.service.MonitoringInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sc/api/monitor")
public class MonitoringInfoController {

    @Autowired
    private MonitoringInfoService monitoringInfoService;

    @PostMapping(path = "add")
    public ResponseEntity<BaseResult> addMonitoringInfo(@ModelAttribute MonitoringInfo monitoringInfo) {

        boolean res = monitoringInfoService.save(monitoringInfo);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("添加成功", monitoringInfo));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "delete")
    public ResponseEntity<BaseResult> deleteMonitoringInfo(@ModelAttribute MonitoringInfo monitoringInfo) {
        boolean res = monitoringInfoService.removeById(monitoringInfo);

        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("删除成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "update")
    public ResponseEntity<BaseResult> updateMonitoringInfo(@ModelAttribute MonitoringInfo monitoringInfo) {

        boolean res = monitoringInfoService.updateById(monitoringInfo);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("修改成功", monitoringInfo));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }
}