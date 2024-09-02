package com.sc.scbackend.SCPending.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sc.scbackend.SCPending.domain.Complaint;
import com.sc.scbackend.SCPending.dto.SelectComplaintByStatusRequest;
import com.sc.scbackend.SCPending.service.ComplaintService;
import com.sc.scbackend.base.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sc/api/complaint")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @PostMapping(path = "add")
    public ResponseEntity<BaseResult> addComplaint(@RequestBody Complaint complaint) {

        boolean res = complaintService.save(complaint);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("添加成功", complaint));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "delete")
    public ResponseEntity<BaseResult> deleteComplaint(@RequestBody Complaint complaint) {
        boolean res = complaintService.removeById(complaint);

        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("删除成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "update")
    public ResponseEntity<BaseResult> updateComplaint(@RequestBody Complaint complaint) {

        boolean res = complaintService.updateById(complaint);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("修改成功", complaint));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "findall")
    public ResponseEntity<BaseResult> selectAllComplaint() {
        List<Complaint> res = complaintService.list();
        if (res != null) {
            return ResponseEntity.ok().body(BaseResult.success("查询成功", res));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "findbycondition")
    public ResponseEntity<BaseResult> selectComplaintByStatus(@RequestBody SelectComplaintByStatusRequest selectComplaintByStatusRequest) {

        QueryWrapper<Complaint> queryWrapper = new QueryWrapper<>();
        if (selectComplaintByStatusRequest.getStatus() != null) {
            queryWrapper.eq("ComplaintStatus", selectComplaintByStatusRequest.getStatus());
        }

        List<Complaint> res = complaintService.list(queryWrapper);
        if (res != null) {
            return ResponseEntity.ok().body(BaseResult.success("查询成功", res));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }
}