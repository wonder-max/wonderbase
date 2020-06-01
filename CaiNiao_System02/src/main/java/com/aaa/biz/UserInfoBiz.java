package com.aaa.biz;

import com.aaa.entity.MyUserInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;
/**
 * @Author: 菜鸟团队
 * @Version 1.0
 */
public interface UserInfoBiz {

    PageInfo<MyUserInfo> selectAllUser(int page, int limit);
    MyUserInfo selectUserByUsername(String username);
    int insertSelective(MyUserInfo record);
    int delUserByID(List<String> ids);
    int updateByPrimaryKeySelective(MyUserInfo record);
}
