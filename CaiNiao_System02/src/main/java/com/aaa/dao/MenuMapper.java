package com.aaa.dao;

import com.aaa.entity.LayUiTable;
import com.aaa.entity.Menu;
import com.aaa.entity.MyUserInfo;
import com.aaa.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MenuMapper {
    int deleteByPrimaryKey(Integer menuId);

    int insert(Menu record);


    Menu selectByPrimaryKey(Integer menuId);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<LayUiTable> selectMenu();

    List<Menu>  selectAllMenuByName(String loginName);
    //菜单管理
    List<Menu> selectAllMenu();
    int insertSelective(Menu record);
    int delMenuByID( @Param("ids") List<String> ids);
    int updateByPrimaryKeySelective(MyUserInfo record);
    List<Menu> searchMenuById(int menuId);
}