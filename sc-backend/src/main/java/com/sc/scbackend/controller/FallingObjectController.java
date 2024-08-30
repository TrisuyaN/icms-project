package com.sc.scbackend.controller;

import com.sc.scbackend.base.BaseResult;
import com.sc.scbackend.domain.FallingObject;
import com.sc.scbackend.service.FallingObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sc/api/warndanger")
public class FallingObjectController {

    @Autowired
    private FallingObjectService fallingObjectService;

    @PostMapping(path = "add")
    public ResponseEntity<BaseResult> addFallingObject(@ModelAttribute FallingObject fallingObject) {

        boolean res = fallingObjectService.save(fallingObject);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("添加成功", fallingObject));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "delete")
    public ResponseEntity<BaseResult> deleteFallingObject(@ModelAttribute FallingObject fallingObject) {
        boolean res = fallingObjectService.removeById(fallingObject);

        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("删除成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "update")
    public ResponseEntity<BaseResult> updateFallingObject(@ModelAttribute FallingObject fallingObject) {

        boolean res = fallingObjectService.updateById(fallingObject);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("修改成功", fallingObject));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }
}