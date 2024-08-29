package com.sc.scbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.scbackend.dao.ComplaintDao;
import com.sc.scbackend.domain.Complaint;
import com.sc.scbackend.service.ComplaintService;
import org.springframework.stereotype.Component;

@Component
public class ComplaintServiceImpl extends ServiceImpl<ComplaintDao, Complaint> implements ComplaintService {

}
