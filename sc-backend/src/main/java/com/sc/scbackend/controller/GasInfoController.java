package com.sc.scbackend.controller;

import com.sc.scbackend.base.BaseResult;
import com.sc.scbackend.domain.GasInfo;
import com.sc.scbackend.service.GasInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sc/api/gasleak")
public class GasInfoController {

    @Autowired
    private GasInfoService gasInfoService;

    @PostMapping(path = "add")
    public ResponseEntity<BaseResult> addGasInfo(@ModelAttribute GasInfo gasInfo) {

        boolean res = gasInfoService.save(gasInfo);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("添加成功", gasInfo));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "delete")
    public ResponseEntity<BaseResult> deleteGasInfo(@ModelAttribute GasInfo gasInfo) {
        boolean res = gasInfoService.removeById(gasInfo);

        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("删除成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "update")
    public ResponseEntity<BaseResult> updateGasInfo(@ModelAttribute GasInfo gasInfo) {

        boolean res = gasInfoService.updateById(gasInfo);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("修改成功", gasInfo));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }
}