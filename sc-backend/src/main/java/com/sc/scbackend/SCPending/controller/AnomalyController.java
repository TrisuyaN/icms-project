package com.sc.scbackend.SCPending.controller;

import com.sc.scbackend.base.BaseResult;
import com.sc.scbackend.SCPending.domain.Anomaly;
import com.sc.scbackend.SCPending.service.AnomalyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sc/api/ano")
public class AnomalyController {

    @Autowired
    private AnomalyService anomalyService;

    @PostMapping(path = "add")
    public ResponseEntity<BaseResult> addAnomaly(@RequestBody Anomaly anomaly) {

        boolean res = anomalyService.save(anomaly);
        if(res) {
            return ResponseEntity.ok().body(BaseResult.success("添加成功", anomaly));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "delete")
    public ResponseEntity<BaseResult> deleteAnomaly(@RequestBody Anomaly anomaly) {
        boolean res = anomalyService.removeById(anomaly);

        if(res) {
            return ResponseEntity.ok().body(BaseResult.success("删除成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "update")
    public ResponseEntity<BaseResult> updateAnomaly(@RequestBody Anomaly anomaly) {

        boolean res = anomalyService.updateById(anomaly);
        if(res) {
            return ResponseEntity.ok().body(BaseResult.success("修改成功", anomaly));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }
}