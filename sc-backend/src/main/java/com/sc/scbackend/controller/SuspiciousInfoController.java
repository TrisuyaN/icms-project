package com.sc.scbackend.controller;

import com.sc.scbackend.base.BaseResult;
import com.sc.scbackend.domain.SuspiciousInfo;
import com.sc.scbackend.service.SuspiciousInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sc/api/dubiousidentify")
public class SuspiciousInfoController {

    @Autowired
    private SuspiciousInfoService suspiciousInfoService;

    @PostMapping(path = "add")
    public ResponseEntity<BaseResult> addSuspiciousInfo(@ModelAttribute SuspiciousInfo suspiciousInfo) {

        boolean res = suspiciousInfoService.save(suspiciousInfo);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("添加成功", suspiciousInfo));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "delete")
    public ResponseEntity<BaseResult> deleteSuspiciousInfo(@ModelAttribute SuspiciousInfo suspiciousInfo) {
        boolean res = suspiciousInfoService.removeById(suspiciousInfo);

        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("删除成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "update")
    public ResponseEntity<BaseResult> updateSuspiciousInfo(@ModelAttribute SuspiciousInfo suspiciousInfo) {

        boolean res = suspiciousInfoService.updateById(suspiciousInfo);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("修改成功", suspiciousInfo));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }
}