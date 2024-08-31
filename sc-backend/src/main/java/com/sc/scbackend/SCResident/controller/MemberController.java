package com.sc.scbackend.SCResident.controller;

import com.sc.scbackend.base.BaseResult;
import com.sc.scbackend.SCResident.domain.Member;
import com.sc.scbackend.SCResident.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sc/api/household")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping(path = "add")
    public ResponseEntity<BaseResult> addMember(@RequestBody Member member) {

        boolean res = memberService.save(member);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("添加成功", member));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "delete")
    public ResponseEntity<BaseResult> deleteMember(@RequestBody Member member) {
        boolean res = memberService.removeById(member.getId());

        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("删除成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "update")
    public ResponseEntity<BaseResult> updateMember(@RequestBody Member member) {

        boolean res = memberService.updateById(member);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("修改成功", member));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }
}
