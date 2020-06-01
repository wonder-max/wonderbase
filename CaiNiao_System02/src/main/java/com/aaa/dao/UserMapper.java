package com.aaa.dao;

import com.aaa.entity.MyUserInfo;
import com.aaa.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    int resetPassword(User record);

    int insertUserRoleId(User record);

    int updateUserRoleById(User record);

    List<User> searchUserById(int userId);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectUserByUsername(String username);
    int delUserByID( @Param("ids") List<String> ids);
    List<User> selectAllUser();
}