package com.sc.scbackend.controller;

import com.sc.scbackend.base.BaseResult;
import com.sc.scbackend.domain.ElevatorEntry;
import com.sc.scbackend.service.ElevatorEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sc/api/elevatorwarning")
public class ElevatorEntryController {

    @Autowired
    private ElevatorEntryService elevatorEntryService;

    @PostMapping(path = "add")
    public ResponseEntity<BaseResult> addElevatorEntry(@ModelAttribute ElevatorEntry elevatorEntry) {

        boolean res = elevatorEntryService.save(elevatorEntry);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("添加成功", elevatorEntry));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "delete")
    public ResponseEntity<BaseResult> deleteElevatorEntry(@ModelAttribute ElevatorEntry elevatorEntry) {
        boolean res = elevatorEntryService.removeById(elevatorEntry);

        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("删除成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "update")
    public ResponseEntity<BaseResult> updateElevatorEntry(@ModelAttribute ElevatorEntry elevatorEntry) {

        boolean res = elevatorEntryService.updateById(elevatorEntry);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("修改成功", elevatorEntry));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }
}