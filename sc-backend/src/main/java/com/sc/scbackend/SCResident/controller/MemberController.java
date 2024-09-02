package com.sc.scbackend.SCResident.controller;

import com.sc.scbackend.SCResident.domain.Member;
import com.sc.scbackend.SCResident.dto.MemberPropertyInfoDTO;
import com.sc.scbackend.SCResident.dto.SelectMemberPropertyInfoByConditionRequest;
import com.sc.scbackend.SCResident.service.MemberService;
import com.sc.scbackend.base.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @PostMapping(path = "findall")
    public ResponseEntity<BaseResult> selectAllMember() {
        List<Member> res = memberService.list();
        if (res != null) {
            return ResponseEntity.ok().body(BaseResult.success("查询成功", res));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "findbycondition")
    public ResponseEntity<BaseResult> selectMemberPropertyInfoByCondition(@RequestBody SelectMemberPropertyInfoByConditionRequest selectMemberPropertyInfoByConditionRequest) {

        List<MemberPropertyInfoDTO> res = memberService.getMemberPropertyInfoByConditions(
                selectMemberPropertyInfoByConditionRequest.getName(),
                selectMemberPropertyInfoByConditionRequest.getBuildingNumber(),
                selectMemberPropertyInfoByConditionRequest.getUnit(),
                selectMemberPropertyInfoByConditionRequest.getFloorNumber(),
                selectMemberPropertyInfoByConditionRequest.getRoomNumber());

        if (res != null) {
            return ResponseEntity.ok().body(BaseResult.success("查询成功", res));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }
}
