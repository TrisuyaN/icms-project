package com.sc.scbackend.SCEmployee.dao;

import com.github.yulichang.base.MPJBaseMapper;
import com.sc.scbackend.SCEmployee.domain.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface EmployeeDao extends MPJBaseMapper<Employee> {

    @Select("select * from employeeinfo where Account = #{account}")
    Employee getByAccount(@Param("account") String account);

    @Select("SELECT * FROM employeeinfo WHERE PhoneNumber = #{phoneNumber}")
    Employee getByPhoneNumber(@Param("phoneNumber") String phoneNumber);

    @Delete("DELETE FROM employeeinfo WHERE Account = #{account}")
    void deleteByAccount(@Param("account") String account);

}
