package com.sc.scbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.scbackend.dao.MemberPropertyDao;
import com.sc.scbackend.domain.MemberProperty;
import com.sc.scbackend.service.MemberPropertyService;
import org.springframework.stereotype.Component;

@Component
public class MemberPropertyServiceImpl extends ServiceImpl<MemberPropertyDao, MemberProperty> implements MemberPropertyService {

}
