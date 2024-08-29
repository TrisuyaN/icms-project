package com.sc.scbackend.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.yulichang.base.MPJBaseMapper;
import com.sc.scbackend.domain.FireHydrant;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface FireHydrantDao extends MPJBaseMapper<FireHydrant> {

}
