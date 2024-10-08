package com.sc.scbackend.SCPending.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sc.scbackend.SCPending.domain.SuspiciousInfo;
import com.sc.scbackend.SCPending.dto.SelectSuspiciousInfoByStatusRequest;
import com.sc.scbackend.SCPending.service.SuspiciousInfoService;
import com.sc.scbackend.base.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @PostMapping(path = "findall")
    public ResponseEntity<BaseResult> selectAllSuspiciousInfo() {
        List<SuspiciousInfo> res = suspiciousInfoService.list();
        if (res != null) {
            return ResponseEntity.ok().body(BaseResult.success("查询成功", res));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "findbycondition")
    public ResponseEntity<BaseResult> selectSuspiciousInfoByStatus(@RequestBody SelectSuspiciousInfoByStatusRequest selectSuspiciousInfoByStatusRequest) {

        QueryWrapper<SuspiciousInfo> queryWrapper = new QueryWrapper<>();

        if (selectSuspiciousInfoByStatusRequest.getStatus() != null) {
            queryWrapper.eq("Status", selectSuspiciousInfoByStatusRequest.getStatus());

        }

        List<SuspiciousInfo> res = suspiciousInfoService.list(queryWrapper);
        if (res != null) {
            return ResponseEntity.ok().body(BaseResult.success("查询成功", res));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }
}