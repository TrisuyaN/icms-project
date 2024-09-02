package com.sc.scbackend.SCResident.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sc.scbackend.SCResident.domain.Member;
import com.sc.scbackend.SCResident.dto.MemberPropertyInfoDTO;

import java.io.Serializable;
import java.util.List;

public interface MemberService extends IService<Member> {
    List<MemberPropertyInfoDTO> getMemberPropertyInfoByConditions(String name, Integer buildingNumber, String unit, Integer floorNumber, String roomNumber);

    boolean validMemberById(Serializable id);
}
