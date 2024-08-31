package com.sc.scbackend.SCPending.controller;

import com.sc.scbackend.base.BaseResult;
import com.sc.scbackend.SCPending.domain.GasInfo;
import com.sc.scbackend.SCPending.service.GasInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}