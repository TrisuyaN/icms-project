package com.sc.scbackend.controller;

import com.sc.scbackend.base.BaseResult;
import com.sc.scbackend.domain.Complaint;
import com.sc.scbackend.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sc/api/complaint")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @PostMapping(path = "add")
    public ResponseEntity<BaseResult> addComplaint(@ModelAttribute Complaint complaint) {

        boolean res = complaintService.save(complaint);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("添加成功", complaint));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "delete")
    public ResponseEntity<BaseResult> deleteComplaint(@ModelAttribute Complaint complaint) {
        boolean res = complaintService.removeById(complaint);

        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("删除成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "update")
    public ResponseEntity<BaseResult> updateComplaint(@ModelAttribute Complaint complaint) {

        boolean res = complaintService.updateById(complaint);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("修改成功", complaint));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }
}