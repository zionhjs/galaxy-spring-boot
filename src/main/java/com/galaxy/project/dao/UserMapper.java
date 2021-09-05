package com.galaxy.project.dao;

import com.galaxy.project.core.Mapper;
import com.galaxy.project.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends Mapper<User> {

    User selectUser(Long id);

    User findUserByPhone(String phone);

    User findUserByEmail(String email);

    User findUserByUserName(@Param("userName") String userName, @Param("id") Long id);
}
