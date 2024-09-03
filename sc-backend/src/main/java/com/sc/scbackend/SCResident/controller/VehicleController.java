package com.sc.scbackend.SCResident.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sc.scbackend.SCResident.domain.Member;
import com.sc.scbackend.SCResident.domain.Vehicle;
import com.sc.scbackend.SCResident.dto.AddVehicleRequest;
import com.sc.scbackend.SCResident.dto.SelectVehicleByLicensePlateRequest;
import com.sc.scbackend.SCResident.dto.VehicleInfoDTO;
import com.sc.scbackend.SCResident.service.MemberService;
import com.sc.scbackend.SCResident.service.VehicleService;
import com.sc.scbackend.base.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sc/api/car")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private MemberService memberService;

    @PostMapping(path = "add")
    public ResponseEntity<BaseResult> addVehicle(@RequestBody AddVehicleRequest addVehicleRequest) {

        if(!memberService.validMemberById(addVehicleRequest.getResidentId())){
            return ResponseEntity.internalServerError().body(BaseResult.fail("住户不存在"));
        }

        vehicleService.addVehicleInfo(
                addVehicleRequest.getLicensePlate(),
                addVehicleRequest.getRegistrationPhoto(),
                addVehicleRequest.getResidentId()
        );

        return ResponseEntity.ok().body(BaseResult.success("添加成功"));

    }

    @PostMapping(path = "delete")
    public ResponseEntity<BaseResult> delete(@RequestBody Vehicle vehicle) {
        boolean res = vehicleService.removeById(vehicle);

        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("删除成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "findall")
    public ResponseEntity<BaseResult> selectAllVehicle() {
        List<Vehicle> res = vehicleService.list();
        if (res != null) {
            return ResponseEntity.ok().body(BaseResult.success("查询成功", res));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    @PostMapping(path = "findbycondition")
    public ResponseEntity<BaseResult> selectVehicleByLicensePlate(@RequestBody SelectVehicleByLicensePlateRequest selectVehicleByLicensePlateRequest) {

        QueryWrapper<Vehicle> queryWrapper = new QueryWrapper<>();

        if (selectVehicleByLicensePlateRequest.getLicensePlate() != null) {
            queryWrapper.like("license_plate", selectVehicleByLicensePlateRequest.getLicensePlate());

        }
        List<Vehicle> res = vehicleService.list(queryWrapper);
        if (res != null) {
            return ResponseEntity.ok().body(BaseResult.success("查询成功", res));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail());
        }
    }

    // TODO: 接口设计问题：无法通过 name 和 contact_info 定位唯一的 Member
    @PostMapping(path = "update")
    public ResponseEntity<BaseResult> updateVehicleById(@RequestBody VehicleInfoDTO vehicleInfoDTO) {
        List<Member> members = memberService.getMembersByNameAndContact(vehicleInfoDTO.getName(), vehicleInfoDTO.getContactInfo());

        if(members == null){
            return ResponseEntity.badRequest().body(BaseResult.fail("修改失败，无法根据姓名和联系方式找到用户"));
        }

        Vehicle vehicle = vehicleService.getById(vehicleInfoDTO.getId());
        vehicle.setLicensePlate(vehicleInfoDTO.getLicensePlate());
        vehicle.setRegistrationPhoto(vehicleInfoDTO.getRegistrationPhoto());
        vehicle.setResidentId(members.get(0).getId());

        boolean res = vehicleService.updateById(vehicle);
        if (res) {
            return ResponseEntity.ok().body(BaseResult.success("更新成功"));
        } else {
            return ResponseEntity.internalServerError().body(BaseResult.fail("更新失败"));
        }
    }
}
