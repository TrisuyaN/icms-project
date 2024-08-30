package com.sc.scbackend.controller;

import com.sc.scbackend.base.BaseResult;
import com.sc.scbackend.domain.GreenEnvironmentInfo;
import com.sc.scbackend.service.GreenEnvironmentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sc/api/greening")
public class GreenEnvironmentInfoController {

    @Autowired
    private GreenEnvironmentInfoService greenEnvironmentInfoService;

    @PostMapping(path = "add")
    public ResponseEntity<BaseResult> addGreenEnvironmentInfo(@ModelAttribute GreenEnvironmentInfo greenEnvironmentInfo) {

        boolean res = greenEnvironmentInfoService.save(greenEnvironmentInfo);
        if(res) {
            return ResponseEntity.ok().body(BaseResult.success("添加成功", greenEnvironmentInfo));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "delete")
    public ResponseEntity<BaseResult> deleteGreenEnvironmentInfo(@ModelAttribute GreenEnvironmentInfo greenEnvironmentInfo) {
        boolean res = greenEnvironmentInfoService.removeById(greenEnvironmentInfo);

        if(res) {
            return ResponseEntity.ok().body(BaseResult.success("删除成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "update")
    public ResponseEntity<BaseResult> updateGreenEnvironmentInfo(@ModelAttribute GreenEnvironmentInfo greenEnvironmentInfo) {

        boolean res = greenEnvironmentInfoService.updateById(greenEnvironmentInfo);
        if(res) {
            return ResponseEntity.ok().body(BaseResult.success("修改成功", greenEnvironmentInfo));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }
}