package com.arcesium.mapper;

import com.arcesium.model.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by amanpsc on 12/11/15.
 */

public interface EmployeeMapper {
    @Insert("INSERT into Employee(id,name,managerid) VALUES(#{eid}, #{name}, #{mid})")
    void insertEmployee(Employee e);

    @Delete("DELETE from Employee(id,name,managerid) where id = #{eid}")
    void deleteEmployee(Integer eid);

    @Update("Update Employee(id,name,managerid) set name = #{name}")
    void updateName(String name);

    @Select("SELECT name from Employee(id,name,managerid) where id = #{eid}")
    String getName(Integer eid);
}
