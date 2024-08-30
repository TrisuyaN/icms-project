package com.sc.scbackend.controller;

import com.sc.scbackend.base.BaseResult;
import com.sc.scbackend.domain.TrashBinViolation;
import com.sc.scbackend.service.TrashBinViolationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sc/api/Garbage_sorting")
public class TrashBinViolationController {

    @Autowired
    private TrashBinViolationService trashBinViolationService;

    @PostMapping(path = "add")
    public ResponseEntity<BaseResult> addMember(@ModelAttribute TrashBinViolation trashBinViolation) {

        boolean res = trashBinViolationService.save(trashBinViolation);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("添加成功", trashBinViolation));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "delete")
    public ResponseEntity<BaseResult> delete(@ModelAttribute TrashBinViolation trashBinViolation) {
        boolean res = trashBinViolationService.removeById(trashBinViolation);

        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("删除成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "update")
    public ResponseEntity<BaseResult> update(@ModelAttribute TrashBinViolation trashBinViolation) {

        boolean res = trashBinViolationService.updateById(trashBinViolation);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("修改成功", trashBinViolation));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }
}