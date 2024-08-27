package com.sc.scbackend.dao;

import com.sc.scbackend.domain.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface EmployeeDao {

    @Select("select * from employeeinfo where Account = #{account}")
    Employee getByAccount(@Param("account") String account);

    @Select("SELECT * FROM employeeinfo WHERE ID = #{id}")
    Employee getById(@Param("id") String id);

    @Select("SELECT * FROM employeeinfo WHERE PhoneNumber = #{phoneNumber}")
    Employee getByPhoneNumber(@Param("phoneNumber") String phoneNumber);

    @Insert("INSERT INTO employeeinfo (ID, Name, Position, Status, Account, Password, PhoneNumber) " +
            "VALUES (#{id}, #{name}, #{position}, #{status}, #{account}, #{password}, #{phoneNumber})")
    void insert(Employee employee);

    @Update("UPDATE employeeinfo SET Name = #{name}, Position = #{position}, Status = #{status}, " +
            "Password = #{password}, PhoneNumber = #{phoneNumber} WHERE ID = #{id}")
    void update(Employee employee);

    @Delete("DELETE FROM employeeinfo WHERE ID = #{employee.id}")
    void delete(@Param("employee") Employee employee);

    @Delete("DELETE FROM employeeinfo WHERE ID = #{id}")
    void deleteById(@Param("id") String id);

    @Delete("DELETE FROM employeeinfo WHERE Account = #{account}")
    void deleteByAccount(@Param("account") String account);

    @Select("SELECT * FROM employeeinfo")
    List<Employee> getAll();
}
