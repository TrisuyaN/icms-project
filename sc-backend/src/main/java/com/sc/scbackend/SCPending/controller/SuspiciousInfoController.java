package com.sc.scbackend.SCPending.controller;

import com.sc.scbackend.base.BaseResult;
import com.sc.scbackend.SCPending.domain.SuspiciousInfo;
import com.sc.scbackend.SCPending.service.SuspiciousInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sc/api/dubiousidentify")
public class SuspiciousInfoController {

    @Autowired
    private SuspiciousInfoService suspiciousInfoService;

    @PostMapping(path = "add")
    public ResponseEntity<BaseResult> addSuspiciousInfo(@RequestBody SuspiciousInfo suspiciousInfo) {

        boolean res = suspiciousInfoService.save(suspiciousInfo);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("添加成功", suspiciousInfo));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "delete")
    public ResponseEntity<BaseResult> deleteSuspiciousInfo(@RequestBody SuspiciousInfo suspiciousInfo) {
        boolean res = suspiciousInfoService.removeById(suspiciousInfo);

        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("删除成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "update")
    public ResponseEntity<BaseResult> updateSuspiciousInfo(@RequestBody SuspiciousInfo suspiciousInfo) {

        boolean res = suspiciousInfoService.updateById(suspiciousInfo);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("修改成功", suspiciousInfo));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }
}