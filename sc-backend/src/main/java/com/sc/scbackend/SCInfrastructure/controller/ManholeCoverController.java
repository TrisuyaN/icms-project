package com.sc.scbackend.SCInfrastructure.controller;

import com.sc.scbackend.base.BaseResult;
import com.sc.scbackend.SCInfrastructure.domain.ManholeCover;
import com.sc.scbackend.SCInfrastructure.service.ManholeCoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}