package com.sc.scbackend.SCPending.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sc.scbackend.SCPending.domain.TrashBinViolation;
import com.sc.scbackend.SCPending.dto.SelectByViolationTypeRequest;
import com.sc.scbackend.SCPending.service.TrashBinViolationService;
import com.sc.scbackend.base.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sc/api/Garbage_sorting")
public class TrashBinViolationController {

    @Autowired
    private TrashBinViolationService trashBinViolationService;

    @PostMapping(path = "add")
    public ResponseEntity<BaseResult> addMember(@RequestBody TrashBinViolation trashBinViolation) {

        boolean res = trashBinViolationService.save(trashBinViolation);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("添加成功", trashBinViolation));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "delete")
    public ResponseEntity<BaseResult> delete(@RequestBody TrashBinViolation trashBinViolation) {
        boolean res = trashBinViolationService.removeById(trashBinViolation);

        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("删除成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "update")
    public ResponseEntity<BaseResult> update(@RequestBody TrashBinViolation trashBinViolation) {

        boolean res = trashBinViolationService.updateById(trashBinViolation);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("修改成功", trashBinViolation));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "findall")
    public ResponseEntity<BaseResult> selectAllTrashBinViolation() {
        List<TrashBinViolation> res = trashBinViolationService.list();
        if (res != null) {
            return ResponseEntity.ok().body(BaseResult.success("查询成功", res));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }


    @PostMapping(path = "findbycondition")
    public ResponseEntity<BaseResult> selectTrashBinViolationByViolationType(@RequestBody SelectByViolationTypeRequest selectByViolationTypeRequest) {

        QueryWrapper<TrashBinViolation> queryWrapper = new QueryWrapper<>();
        if (selectByViolationTypeRequest.getTrashBinViolationType() != null) {
            queryWrapper.eq("ViolationType", selectByViolationTypeRequest.getTrashBinViolationType());
        }

        List<TrashBinViolation> res = trashBinViolationService.list(queryWrapper);
        if (res != null) {
            return ResponseEntity.ok().body(BaseResult.success("查询成功", res));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }
}