package com.sc.scbackend.controller;

import com.sc.scbackend.base.BaseResult;
import com.sc.scbackend.domain.Member;
import com.sc.scbackend.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sc/api/household")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping(path = "add")
    public ResponseEntity<BaseResult> addMember(@ModelAttribute Member member) {

        boolean res = memberService.save(member);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("添加成功", member));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "delete")
    public ResponseEntity<BaseResult> deleteMember(@ModelAttribute Member member) {
        boolean res = memberService.removeById(member.getId());

        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("删除成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "update")
    public ResponseEntity<BaseResult> updateMember(@ModelAttribute Member member) {

        boolean res = memberService.updateById(member);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("修改成功", member));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }
}
