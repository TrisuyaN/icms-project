package com.sc.scbackend.controller;

import com.sc.scbackend.base.BaseResult;
import com.sc.scbackend.domain.TrashBinInfo;
import com.sc.scbackend.service.TrashBinInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sc/api/Garbage")
public class TrashbinInfoController {

    @Autowired
    private TrashBinInfoService trashBinInfoService;

    @PostMapping(path = "add")
    public ResponseEntity<BaseResult> addTrashbinInfo(@ModelAttribute TrashBinInfo trashBinInfo) {

        boolean res = trashBinInfoService.save(trashBinInfo);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("添加成功", trashBinInfo));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "delete")
    public ResponseEntity<BaseResult> deleteTrashbinInfo(@ModelAttribute TrashBinInfo trashBinInfo) {
        boolean res = trashBinInfoService.removeById(trashBinInfo);

        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("删除成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }
}
