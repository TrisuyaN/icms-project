package com.sc.scbackend.controller;

import com.sc.scbackend.base.BaseResult;
import com.sc.scbackend.domain.FireHydrant;
import com.sc.scbackend.service.FireHydrantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sc/api/firehydrant")
public class FireHydrantController {

    @Autowired
    private FireHydrantService fireHydrantService;

    @PostMapping(path = "add")
    public ResponseEntity<BaseResult> addFireHydrant(@ModelAttribute FireHydrant fireHydrant) {

        boolean res = fireHydrantService.save(fireHydrant);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("添加成功", fireHydrant));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "delete")
    public ResponseEntity<BaseResult> deleteFireHydrant(@ModelAttribute FireHydrant fireHydrant) {
        boolean res = fireHydrantService.removeById(fireHydrant);

        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("删除成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "update")
    public ResponseEntity<BaseResult> updateFireHydrant(@ModelAttribute FireHydrant fireHydrant) {

        boolean res = fireHydrantService.updateById(fireHydrant);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("修改成功", fireHydrant));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }
}
