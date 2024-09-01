package com.sc.scbackend.SCPending.controller;

import com.sc.scbackend.base.BaseResult;
import com.sc.scbackend.SCPending.domain.FallingObject;
import com.sc.scbackend.SCPending.service.FallingObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sc/api/warndanger")
public class FallingObjectController {

    @Autowired
    private FallingObjectService fallingObjectService;

    @PostMapping(path = "add")
    public ResponseEntity<BaseResult> addFallingObject(@RequestBody FallingObject fallingObject) {

        boolean res = fallingObjectService.save(fallingObject);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("添加成功", fallingObject));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "delete")
    public ResponseEntity<BaseResult> deleteFallingObject(@RequestBody FallingObject fallingObject) {
        boolean res = fallingObjectService.removeById(fallingObject);

        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("删除成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "update")
    public ResponseEntity<BaseResult> updateFallingObject(@RequestBody FallingObject fallingObject) {

        boolean res = fallingObjectService.updateById(fallingObject);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("修改成功", fallingObject));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "findall")
    public ResponseEntity<BaseResult> selectAllFallingObject() {
        List<FallingObject> res = fallingObjectService.list();
        if (res != null) {
            return ResponseEntity.ok().body(BaseResult.success("查询成功", res));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }
}