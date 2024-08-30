package com.sc.scbackend.controller;

import com.sc.scbackend.base.BaseResult;
import com.sc.scbackend.domain.Anomaly;
import com.sc.scbackend.service.AnomalyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sc/api/ano")
public class AnomalyController {

    @Autowired
    private AnomalyService anomalyService;

    @PostMapping(path = "add")
    public ResponseEntity<BaseResult> addAnomaly(@ModelAttribute Anomaly anomaly) {

        boolean res = anomalyService.save(anomaly);
        if(res) {
            return ResponseEntity.ok().body(BaseResult.success("添加成功", anomaly));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "delete")
    public ResponseEntity<BaseResult> deleteAnomaly(@ModelAttribute Anomaly anomaly) {
        boolean res = anomalyService.removeById(anomaly);

        if(res) {
            return ResponseEntity.ok().body(BaseResult.success("删除成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "update")
    public ResponseEntity<BaseResult> updateAnomaly(@ModelAttribute Anomaly anomaly) {

        boolean res = anomalyService.updateById(anomaly);
        if(res) {
            return ResponseEntity.ok().body(BaseResult.success("修改成功", anomaly));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }
}