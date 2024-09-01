package com.sc.scbackend.SCPending.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sc.scbackend.SCPending.domain.Anomaly;
import com.sc.scbackend.SCPending.dto.SelectAnomalyByStatusRequest;
import com.sc.scbackend.SCPending.enums.AnomalyCategory;
import com.sc.scbackend.SCPending.service.AnomalyService;
import com.sc.scbackend.base.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sc/api/ano")
public class AnomalyController {

    @Autowired
    private AnomalyService anomalyService;

    @PostMapping(path = "add")
    public ResponseEntity<BaseResult> addAnomaly(@RequestBody Anomaly anomaly) {

        boolean res = anomalyService.save(anomaly);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("添加成功", anomaly));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "delete")
    public ResponseEntity<BaseResult> deleteAnomaly(@RequestBody Anomaly anomaly) {
        boolean res = anomalyService.removeById(anomaly);

        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("删除成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "update")
    public ResponseEntity<BaseResult> updateAnomaly(@RequestBody Anomaly anomaly) {

        boolean res = anomalyService.updateById(anomaly);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("修改成功", anomaly));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "findall")
    public ResponseEntity<BaseResult> selectAllAnomaly() {
        List<Anomaly> res = anomalyService.list();
        if (res != null) {
            return ResponseEntity.ok().body(BaseResult.success("查询成功", res));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "find_pa_bycondition")
    public ResponseEntity<BaseResult> selectPipeAnoByStatus(@RequestBody SelectAnomalyByStatusRequest selectAnomalyByStatusRequest) {

        QueryWrapper<Anomaly> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("Category", AnomalyCategory.WATER);
        if (selectAnomalyByStatusRequest.getStatus() != null) {
            queryWrapper.eq("ProcessingStatus", selectAnomalyByStatusRequest.getStatus());
        }

        List<Anomaly> res = anomalyService.list(queryWrapper);
        if (res != null) {
            return ResponseEntity.ok().body(BaseResult.success("查询成功", res));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "find_wa_bycondition")
    public ResponseEntity<BaseResult> selectWireAnoByStatus(@RequestBody SelectAnomalyByStatusRequest selectAnomalyByStatusRequest) {

        QueryWrapper<Anomaly> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("Category", AnomalyCategory.ELECTRICITY);
        if (selectAnomalyByStatusRequest.getStatus() != null) {
            queryWrapper.eq("ProcessingStatus", selectAnomalyByStatusRequest.getStatus());
        }

        List<Anomaly> res = anomalyService.list(queryWrapper);
        if (res != null) {
            return ResponseEntity.ok().body(BaseResult.success("查询成功", res));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }
}