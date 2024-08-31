package com.sc.scbackend.SCPending.controller;

import com.sc.scbackend.base.BaseResult;
import com.sc.scbackend.SCPending.domain.GreenEnvironmentInfo;
import com.sc.scbackend.SCPending.service.GreenEnvironmentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sc/api/greening")
public class GreenEnvironmentInfoController {

    @Autowired
    private GreenEnvironmentInfoService greenEnvironmentInfoService;

    @PostMapping(path = "add")
    public ResponseEntity<BaseResult> addGreenEnvironmentInfo(@RequestBody GreenEnvironmentInfo greenEnvironmentInfo) {

        boolean res = greenEnvironmentInfoService.save(greenEnvironmentInfo);
        if(res) {
            return ResponseEntity.ok().body(BaseResult.success("添加成功", greenEnvironmentInfo));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "delete")
    public ResponseEntity<BaseResult> deleteGreenEnvironmentInfo(@RequestBody GreenEnvironmentInfo greenEnvironmentInfo) {
        boolean res = greenEnvironmentInfoService.removeById(greenEnvironmentInfo);

        if(res) {
            return ResponseEntity.ok().body(BaseResult.success("删除成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "update")
    public ResponseEntity<BaseResult> updateGreenEnvironmentInfo(@RequestBody GreenEnvironmentInfo greenEnvironmentInfo) {

        boolean res = greenEnvironmentInfoService.updateById(greenEnvironmentInfo);
        if(res) {
            return ResponseEntity.ok().body(BaseResult.success("修改成功", greenEnvironmentInfo));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }
}