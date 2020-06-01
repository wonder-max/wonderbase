package com.aaa.biz;

import com.aaa.entity.LayUiTable;
import com.aaa.entity.LayUiTree;
import com.aaa.entity.Menu;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface MenuBiz {
    int deleteByPrimaryKey(Integer menuId);

    int insert(Menu record);


    Menu selectByPrimaryKey(Integer menuId);


    List<Menu> searchMenuById(int menuId);
    List<LayUiTable> selectMenu();

    int updateByPrimaryKey(Menu record);

    List<LayUiTree>  selectAllMenu();
//    List<Menu>  selectAllMenu();
    //根据用户登录名查询对应的所有菜单
    List<LayUiTree>  selectAllMenuByName(String loginName);
    //菜单管理
    PageInfo<Menu> selectAllMenu(int page, int limit);
    int insertSelective(Menu record);
    int delMenuByID(List<String> ids);
    int updateByPrimaryKeySelective(Menu record);
}