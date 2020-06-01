package com.aaa.biz.impl;

import com.aaa.biz.RoleBiz;
import com.aaa.dao.RoleMapper;
import com.aaa.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 菜鸟团队
 * @Version 1.0
 */
@Service
public class RoleBizImpl implements RoleBiz {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Role> selectAllRole() {
        return roleMapper.selectAllRole();
    }

    @Override
    public int insertSelective(Role record) {
        return roleMapper.insertSelective(record);
    }
    @Override
    public int delRoleByID(List<String> ids) {
        return roleMapper.delRoleByID(ids);
    }
    @Override
    public int updateByPrimaryKeySelective(Role record) {
        return roleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Role selectByPrimaryKey(Integer roleId) {
        return roleMapper.selectByPrimaryKey(roleId);
    }
    @Override
    public int insertRoleMenu(Role record){return roleMapper.insertRoleMenu(record);}
    @Override
    public List<Role> searchRoleById(int roleId) {
        return roleMapper.searchRoleById(roleId);
    }

}
