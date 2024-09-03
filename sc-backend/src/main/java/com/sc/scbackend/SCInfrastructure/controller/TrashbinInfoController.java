package com.sc.scbackend.SCInfrastructure.controller;

import com.sc.scbackend.SCInfrastructure.dto.AddTrashBinInfoRequest;
import com.sc.scbackend.SCInfrastructure.dto.TrashBinInfoDTO;
import com.sc.scbackend.base.BaseResult;
import com.sc.scbackend.SCInfrastructure.domain.TrashBinInfo;
import com.sc.scbackend.SCInfrastructure.service.TrashBinInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sc/api/Garbage")
public class TrashbinInfoController {

    @Autowired
    private TrashBinInfoService trashBinInfoService;

    @PostMapping(path = "add")
    public ResponseEntity<BaseResult> addTrashbinInfo(@RequestBody AddTrashBinInfoRequest addTrashBinInfoRequest) {

        TrashBinInfoDTO trashBinInfoDTO = new TrashBinInfoDTO();
        trashBinInfoDTO.setStatus(addTrashBinInfoRequest.getStatus());
        trashBinInfoDTO.setBinType(addTrashBinInfoRequest.getBinType());
        trashBinInfoDTO.setCapacity(addTrashBinInfoRequest.getCapacity());
        trashBinInfoDTO.setLocationName(addTrashBinInfoRequest.getLocationName());

        String message = trashBinInfoService.addTrashBinInfo(trashBinInfoDTO);

        if (message == null) {
            return ResponseEntity.ok().body(BaseResult.success("添加成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail(message));
        }
    }

    @PostMapping(path = "delete")
    public ResponseEntity<BaseResult> deleteTrashbinInfo(@RequestBody TrashBinInfo trashBinInfo) {
        boolean res = trashBinInfoService.removeById(trashBinInfo);

        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("删除成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "findall")
    public ResponseEntity<BaseResult> selectAllTrashBinInfo() {
        List<TrashBinInfoDTO> res = trashBinInfoService.getAllTrashBinInfo();
        if (res != null) {
            return ResponseEntity.ok().body(BaseResult.success("查询成功", res));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "update")
    public ResponseEntity<BaseResult> updateTrashBinInfo(@RequestBody TrashBinInfoDTO trashBinInfoDTO) {
        String message = trashBinInfoService.updateTrashBinInfo(trashBinInfoDTO);
        if (message == null) {
            return ResponseEntity.ok().body(BaseResult.success("更新成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail(message));
        }
    }
}
