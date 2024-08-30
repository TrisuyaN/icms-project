package com.sc.scbackend.controller;

import com.sc.scbackend.base.BaseResult;
import com.sc.scbackend.domain.MemberProperty;
import com.sc.scbackend.service.MemberPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sc/api/")
public class MemberPropertyController {

    @Autowired
    private MemberPropertyService memberPropertyService;

    @PostMapping(path = "add", consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<BaseResult> addMemberProperty(@ModelAttribute MemberProperty memberProperty) {

        boolean res = memberPropertyService.save(memberProperty);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("添加成功", memberProperty));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "delete", consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<BaseResult> deleteMemberProperty(@ModelAttribute MemberProperty memberProperty) {
        boolean res = memberPropertyService.removeById(memberProperty);

        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("删除成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "update", consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<BaseResult> updateMemberProperty(@ModelAttribute MemberProperty memberProperty) {

        boolean res = memberPropertyService.updateById(memberProperty);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("修改成功", memberProperty));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }
}