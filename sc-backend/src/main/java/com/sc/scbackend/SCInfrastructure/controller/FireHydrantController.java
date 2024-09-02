package com.sc.scbackend.SCInfrastructure.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sc.scbackend.SCInfrastructure.domain.FireHydrant;
import com.sc.scbackend.SCInfrastructure.dto.SelectByFireHydrantStatusRequest;
import com.sc.scbackend.SCInfrastructure.service.FireHydrantService;
import com.sc.scbackend.base.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sc/api/firehydrant")
public class FireHydrantController {

    @Autowired
    private FireHydrantService fireHydrantService;

    @PostMapping(path = "add")
    public ResponseEntity<BaseResult> addFireHydrant(@RequestBody FireHydrant fireHydrant) {

        boolean res = fireHydrantService.save(fireHydrant);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("添加成功", fireHydrant));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "delete")
    public ResponseEntity<BaseResult> deleteFireHydrant(@RequestBody FireHydrant fireHydrant) {
        boolean res = fireHydrantService.removeById(fireHydrant);

        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("删除成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "update")
    public ResponseEntity<BaseResult> updateFireHydrant(@RequestBody FireHydrant fireHydrant) {

        boolean res = fireHydrantService.updateById(fireHydrant);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("修改成功", fireHydrant));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "findall")
    public ResponseEntity<BaseResult> selectAllFireHydrant() {
        List<FireHydrant> res = fireHydrantService.list();
        if (res != null) {
            return ResponseEntity.ok().body(BaseResult.success("查询成功", res));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "findbycondition")
    public ResponseEntity<BaseResult> selectByFireHydrantStatus(@RequestBody SelectByFireHydrantStatusRequest selectByFireHydrantStatusRequest) {

        QueryWrapper<FireHydrant> queryWrapper = new QueryWrapper<>();

        // TODO：值为空情况下默认为 false
        queryWrapper.eq("IsQualified", selectByFireHydrantStatusRequest.isQualified());


        List<FireHydrant> res = fireHydrantService.list(queryWrapper);
        if (res != null) {
            return ResponseEntity.ok().body(BaseResult.success("查询成功", res));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }
}
