package com.sc.scbackend.controller;

import com.sc.scbackend.base.BaseResult;
import com.sc.scbackend.domain.ManholeCover;
import com.sc.scbackend.service.ManholeCoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sc/api/manholecover")
public class ManholeCoverController {

    @Autowired
    private ManholeCoverService manholeCoverService;

    @PostMapping(path = "add", consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<BaseResult> addManholeCover(@ModelAttribute ManholeCover manholeCover) {

        boolean res = manholeCoverService.save(manholeCover);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("添加成功", manholeCover));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "delete", consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<BaseResult> deleteManholeCover(@ModelAttribute ManholeCover manholeCover) {
        boolean res = manholeCoverService.removeById(manholeCover);

        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("删除成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "update", consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<BaseResult> updateManholeCover(@ModelAttribute ManholeCover manholeCover) {

        boolean res = manholeCoverService.updateById(manholeCover);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("修改成功", manholeCover));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }
}