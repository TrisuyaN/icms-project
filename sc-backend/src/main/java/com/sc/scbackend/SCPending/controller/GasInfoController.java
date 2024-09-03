package com.sc.scbackend.SCPending.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.sc.scbackend.SCPending.domain.GasInfo;
import com.sc.scbackend.SCPending.dto.GasPropertyInfoDTO;
import com.sc.scbackend.SCPending.dto.SelectGasInfoByConditionRequest;
import com.sc.scbackend.SCPending.service.GasInfoService;
import com.sc.scbackend.SCResident.domain.PropertyInfo;
import com.sc.scbackend.base.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sc/api/gasleak")
public class GasInfoController {

    @Autowired
    private GasInfoService gasInfoService;

    @PostMapping(path = "add")
    public ResponseEntity<BaseResult> addGasInfo(@RequestBody GasInfo gasInfo) {

        boolean res = gasInfoService.save(gasInfo);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("添加成功", gasInfo));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "delete")
    public ResponseEntity<BaseResult> deleteGasInfo(@RequestBody GasInfo gasInfo) {
        boolean res = gasInfoService.removeById(gasInfo);

        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("删除成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "update")
    public ResponseEntity<BaseResult> updateGasInfo(@RequestBody GasInfo gasInfo) {

        boolean res = gasInfoService.updateById(gasInfo);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("修改成功", gasInfo));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "findall")
    public ResponseEntity<BaseResult> selectAllGasPropertyInfo() {

        List<GasPropertyInfoDTO> res = gasInfoService.getAllGasPropertyInfo();

        if (res != null) {
            return ResponseEntity.ok().body(BaseResult.success("查询成功", res));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "findbycondition")
    public ResponseEntity<BaseResult> selectGasInfoByCondition(@RequestBody SelectGasInfoByConditionRequest selectGasInfoByConditionRequest) {

        List<GasPropertyInfoDTO> res = gasInfoService.getAllGasPropertyInfoByConditions(
                selectGasInfoByConditionRequest.getUrgencyLevel(),
                selectGasInfoByConditionRequest.getStatus()
        );

        if (res != null) {
            return ResponseEntity.ok().body(BaseResult.success("查询成功", res));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }
}