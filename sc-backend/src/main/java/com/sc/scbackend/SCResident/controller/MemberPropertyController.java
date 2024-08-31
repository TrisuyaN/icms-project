package com.sc.scbackend.SCResident.controller;

import com.sc.scbackend.base.BaseResult;
import com.sc.scbackend.SCResident.domain.MemberProperty;
import com.sc.scbackend.SCResident.service.MemberPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sc/api/")
public class MemberPropertyController {

    @Autowired
    private MemberPropertyService memberPropertyService;

    @PostMapping(path = "add")
    public ResponseEntity<BaseResult> addMemberProperty(@RequestBody MemberProperty memberProperty) {

        boolean res = memberPropertyService.save(memberProperty);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("添加成功", memberProperty));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "delete")
    public ResponseEntity<BaseResult> deleteMemberProperty(@RequestBody MemberProperty memberProperty) {
        boolean res = memberPropertyService.removeById(memberProperty);

        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("删除成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "update")
    public ResponseEntity<BaseResult> updateMemberProperty(@RequestBody MemberProperty memberProperty) {

        boolean res = memberPropertyService.updateById(memberProperty);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("修改成功", memberProperty));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }
}