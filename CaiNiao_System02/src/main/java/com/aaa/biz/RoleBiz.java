package com.aaa.biz;

import com.aaa.entity.Role;
import com.aaa.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author: 菜鸟团队
 * @Version 1.0
 */
public interface  RoleBiz {
   List<Role> selectAllRole();
   int insertSelective(Role record);
   int delRoleByID(List<String> ids);
   int updateByPrimaryKeySelective(Role record);
   Role selectByPrimaryKey(Integer roleId);
   int insertRoleMenu(Role record);
   List<Role> searchRoleById(int roleId);
}
