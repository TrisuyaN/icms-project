package com.sc.scbackend.SCResident.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.sc.scbackend.SCResident.dao.MemberDao;
import com.sc.scbackend.SCResident.domain.Member;
import com.sc.scbackend.SCResident.domain.MemberProperty;
import com.sc.scbackend.SCResident.domain.PropertyInfo;
import com.sc.scbackend.SCResident.dto.MemberPropertyInfoDTO;
import com.sc.scbackend.SCResident.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
public class MemberServiceImpl extends ServiceImpl<MemberDao, Member> implements MemberService {

    @Autowired
    private MemberDao memberDao;

    @Override
    public List<MemberPropertyInfoDTO> getMemberPropertyInfoByConditions(String name, Integer buildingNumber, String unit, Integer floorNumber, String roomNumber) {
        MPJLambdaWrapper<Member> wrapper = new MPJLambdaWrapper<>();

        wrapper.selectAll(Member.class)
                .selectAll(MemberProperty.class)
                .selectAll(PropertyInfo.class)
                .leftJoin(MemberProperty.class, MemberProperty::getMemberId, Member::getId)
                .leftJoin(PropertyInfo.class, PropertyInfo::getId, MemberProperty::getPropertyId);
        if (name != null) {
            wrapper.like(Member::getName, name);
        }
        if (buildingNumber != null) {
            wrapper.eq(PropertyInfo::getBuildingNumber, buildingNumber);
        }
        if (unit != null) {
            wrapper.eq(PropertyInfo::getUnit, unit);
        }
        if (floorNumber != null) {
            wrapper.eq(PropertyInfo::getFloorNumber, floorNumber);
        }
        if (roomNumber != null) {
            wrapper.eq(PropertyInfo::getRoomNumber, roomNumber);
        }

        List<MemberPropertyInfoDTO> res = memberDao.selectJoinList(MemberPropertyInfoDTO.class, wrapper);

        return res;
    }

    @Override
    public List<Member> getMembersByNameAndContact(String name, String contact) {
        return memberDao.selectByNameAndContact(name, contact);
    }

    @Override
    public boolean validMemberById(Serializable id) {
        return memberDao.selectById(id) != null;
    }

    @Override
    public boolean validMemberByName(String name) {
        return memberDao.selectByName(name) != null;
    }

    @Override
    public boolean validMemberByContact(String phoneNumber) {
        return memberDao.selectByContact(phoneNumber) != null;
    }

    @Override
    public boolean validateMemberByNameAndContact(String name, String contact) {
       return memberDao.selectByNameAndContact(name, contact) != null;
    }
}
