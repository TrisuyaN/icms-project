package com.sc.scbackend.SCResident.dao;

import com.github.yulichang.base.MPJBaseMapper;
import com.sc.scbackend.SCEmployee.domain.Employee;
import com.sc.scbackend.SCResident.domain.Member;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface MemberDao extends MPJBaseMapper<Member> {

    // should not use, just valid if exists
    @Select("select * from members where name = #{name}")
    Member selectByName(@Param("name") String name);

    @Select("select * from members where name like #{name}")
    List<Member> selectLikeName(@Param("name") String name);

    // should not use, just valid if exists
    @Select("select * from members where contact_info = #{contact}")
    Member selectByContact(@Param("contact") String contact);

    @Select("select * from members where name = #{name} and contact_info = #{contact}")
    List<Member> selectByNameAndContact(@Param("name") String name, @Param("contact") String contact);
}
