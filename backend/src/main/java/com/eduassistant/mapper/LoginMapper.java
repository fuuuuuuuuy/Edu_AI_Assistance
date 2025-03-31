package com.eduassistant.mapper;

import com.eduassistant.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {

//    @Select("select * from enterprise where admin_id = #{username} and password = #{password}")
//    public Enterprise adminLogin(String username, String password);
//
//    @Select("select * from employee where emp_email = #{username} and emp_password = #{password}")
//    public Employee employeeLogin(String username, String password);

//    @Select("select * from enterprise where admin_id = #{username}")
//    public Enterprise adminLogin(String username);

    @Select("select * from users where user_email = #{username}")
    User userLogin(String username);
}
