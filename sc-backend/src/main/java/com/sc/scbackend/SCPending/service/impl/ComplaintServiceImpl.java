package com.sc.scbackend.SCPending.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.scbackend.SCPending.dao.ComplaintDao;
import com.sc.scbackend.SCPending.domain.Complaint;
import com.sc.scbackend.SCPending.service.ComplaintService;
import org.springframework.stereotype.Component;

@Component
public class ComplaintServiceImpl extends ServiceImpl<ComplaintDao, Complaint> implements ComplaintService {

}
