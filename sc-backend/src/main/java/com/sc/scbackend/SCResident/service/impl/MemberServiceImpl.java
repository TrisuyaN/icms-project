package com.sc.scbackend.SCResident.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.scbackend.SCResident.dao.MemberDao;
import com.sc.scbackend.SCResident.domain.Member;
import com.sc.scbackend.SCResident.service.MemberService;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl extends ServiceImpl<MemberDao, Member> implements MemberService {

}
