package com.sc.scbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.scbackend.dao.MemberDao;
import com.sc.scbackend.domain.Member;
import com.sc.scbackend.service.MemberService;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl extends ServiceImpl<MemberDao, Member> implements MemberService {

}
