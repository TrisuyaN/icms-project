package com.sc.scbackend.SCInfrastructure.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sc.scbackend.SCInfrastructure.domain.ManholeCover;
import com.sc.scbackend.SCInfrastructure.dto.SelectByManholeCoverStatusRequest;
import com.sc.scbackend.SCInfrastructure.service.ManholeCoverService;
import com.sc.scbackend.base.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sc/api/manholecover")
public class ManholeCoverController {

    @Autowired
    private ManholeCoverService manholeCoverService;

    @PostMapping(path = "add")
    public ResponseEntity<BaseResult> addManholeCover(@RequestBody ManholeCover manholeCover) {

        boolean res = manholeCoverService.save(manholeCover);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("添加成功", manholeCover));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "delete")
    public ResponseEntity<BaseResult> deleteManholeCover(@RequestBody ManholeCover manholeCover) {
        boolean res = manholeCoverService.removeById(manholeCover);

        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("删除成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "update")
    public ResponseEntity<BaseResult> updateManholeCover(@RequestBody ManholeCover manholeCover) {

        boolean res = manholeCoverService.updateById(manholeCover);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("修改成功", manholeCover));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "findall")
    public ResponseEntity<BaseResult> selectAllManholeCover() {
        List<ManholeCover> res = manholeCoverService.list();
        if (res != null) {
            return ResponseEntity.ok().body(BaseResult.success("查询成功", res));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "findbycondition")
    public ResponseEntity<BaseResult> selectByManholeCoverStatus(@RequestBody SelectByManholeCoverStatusRequest selectByManholeCoverStatusRequest) {

        QueryWrapper<ManholeCover> queryWrapper = new QueryWrapper<>();

        if (selectByManholeCoverStatusRequest.getManholeCoverStatus() != null) {
            queryWrapper.eq("Status", selectByManholeCoverStatusRequest.getManholeCoverStatus());
        }

        List<ManholeCover> res = manholeCoverService.list(queryWrapper);
        if (res != null) {
            return ResponseEntity.ok().body(BaseResult.success("查询成功", res));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }
}