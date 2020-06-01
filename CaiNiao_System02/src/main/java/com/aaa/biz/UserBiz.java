package com.aaa.biz;

import com.aaa.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author: 菜鸟团队
 * @Version 1.0
 */
public interface UserBiz {

    PageInfo<User> selectAllUser(int page, int limit);
    User selectUserByUsername(String username);
    int insertSelective(User record);
    int delUserByID(List<String> ids);
    int updateUserRoleById(User record);
    int updateByPrimaryKeySelective(User record);
    int insertUserRoleId(User record);
    int resetPassword(User record);
    List<User> searchUserById(int userId);
}
