package com.arcesium.mapper;

import com.arcesium.model.Employee;
import org.apache.ibatis.annotations.*;

import java.util.Collection;
import java.util.List;

/**
 * Created by amanpsc on 12/11/15.
 */

public interface EmployeeMapper {
    @Insert("INSERT into Employee(id,name,managerid) VALUES(#{eid}, #{name}, #{mid})")
    void insertEmployee(Employee e);

    @Delete("DELETE from Employee where id = #{eid}")
    void deleteEmployee(Integer eid);

    @Update("Update Employee set name = #{0} where id = #{1}")
    void updateName(String name, Integer eid);

    @Select("SELECT name from Employee where id = #{eid} limit 1")
    String getName(Integer eid);

    @Select("SELECT * from Employee")
    @Results({
            @Result(property = "eid", column = "id"),
            @Result(property = "mid", column = "managerid")
    })
    Collection<Employee> getEmployees();
}
