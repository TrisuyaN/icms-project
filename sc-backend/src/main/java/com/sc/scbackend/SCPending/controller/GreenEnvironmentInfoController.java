package com.sc.scbackend.SCPending.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sc.scbackend.SCPending.domain.GreenEnvironmentInfo;
import com.sc.scbackend.SCPending.dto.SelectGreenEnvironmentInfoByStatusRequest;
import com.sc.scbackend.SCPending.service.GreenEnvironmentInfoService;
import com.sc.scbackend.base.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sc/api/greening")
public class GreenEnvironmentInfoController {

    @Autowired
    private GreenEnvironmentInfoService greenEnvironmentInfoService;

    @PostMapping(path = "add")
    public ResponseEntity<BaseResult> addGreenEnvironmentInfo(@RequestBody GreenEnvironmentInfo greenEnvironmentInfo) {

        boolean res = greenEnvironmentInfoService.save(greenEnvironmentInfo);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("添加成功", greenEnvironmentInfo));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "delete")
    public ResponseEntity<BaseResult> deleteGreenEnvironmentInfo(@RequestBody GreenEnvironmentInfo greenEnvironmentInfo) {
        boolean res = greenEnvironmentInfoService.removeById(greenEnvironmentInfo);

        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("删除成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "update")
    public ResponseEntity<BaseResult> updateGreenEnvironmentInfo(@RequestBody GreenEnvironmentInfo greenEnvironmentInfo) {

        boolean res = greenEnvironmentInfoService.updateById(greenEnvironmentInfo);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("修改成功", greenEnvironmentInfo));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "findall")
    public ResponseEntity<BaseResult> selectAllGreenEnvironmentInfo() {
        List<GreenEnvironmentInfo> res = greenEnvironmentInfoService.list();
        if (res != null) {
            return ResponseEntity.ok().body(BaseResult.success("查询成功", res));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "findbycondition")
    public ResponseEntity<BaseResult> selectGreenEnvironmentInfoByStatus(@RequestBody SelectGreenEnvironmentInfoByStatusRequest selectGreenEnvironmentInfoByStatusRequest) {

        QueryWrapper<GreenEnvironmentInfo> queryWrapper = new QueryWrapper<>();

        if (selectGreenEnvironmentInfoByStatusRequest.getStatus() != null) {
            queryWrapper.eq("Status", selectGreenEnvironmentInfoByStatusRequest.getStatus());
        }

        List<GreenEnvironmentInfo> res = greenEnvironmentInfoService.list(queryWrapper);
        if (res != null) {
            return ResponseEntity.ok().body(BaseResult.success("查询成功", res));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }
}