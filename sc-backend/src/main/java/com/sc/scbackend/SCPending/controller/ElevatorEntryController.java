package com.sc.scbackend.SCPending.controller;

import com.sc.scbackend.base.BaseResult;
import com.sc.scbackend.SCPending.domain.ElevatorEntry;
import com.sc.scbackend.SCPending.service.ElevatorEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sc/api/elevatorwarning")
public class ElevatorEntryController {

    @Autowired
    private ElevatorEntryService elevatorEntryService;

    @PostMapping(path = "add")
    public ResponseEntity<BaseResult> addElevatorEntry(@RequestBody ElevatorEntry elevatorEntry) {

        boolean res = elevatorEntryService.save(elevatorEntry);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("添加成功", elevatorEntry));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "delete")
    public ResponseEntity<BaseResult> deleteElevatorEntry(@RequestBody ElevatorEntry elevatorEntry) {
        boolean res = elevatorEntryService.removeById(elevatorEntry);

        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("删除成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "update")
    public ResponseEntity<BaseResult> updateElevatorEntry(@RequestBody ElevatorEntry elevatorEntry) {

        boolean res = elevatorEntryService.updateById(elevatorEntry);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("修改成功", elevatorEntry));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "findall")
    public ResponseEntity<BaseResult> selectAllElevatorEntry() {
        List<ElevatorEntry> res = elevatorEntryService.list();
        if (res != null) {
            return ResponseEntity.ok().body(BaseResult.success("查询成功", res));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }
}