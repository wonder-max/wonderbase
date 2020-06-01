package com.aaa.biz.impl;

import com.aaa.biz.MenuBiz;
import com.aaa.dao.MenuMapper;
import com.aaa.entity.LayUiTable;
import com.aaa.entity.LayUiTree;
import com.aaa.entity.Menu;
import com.aaa.util.TreeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 菜鸟团队
 * @Version 1.0
 */
@Service
public class MenuBizImpl implements MenuBiz {
    @Autowired
    private MenuMapper menuMapper;
    @Override
    public int deleteByPrimaryKey(Integer menuId) {
        return 0;
    }

    @Override
    public int insert(Menu record) {
        return 0;
    }


    @Override
    public Menu selectByPrimaryKey(Integer menuId) {
        return null;
    }


    @Override
    public int updateByPrimaryKey(Menu record) {
        return 0;
    }

    /**
     * 查询所有的菜单，并组装成tree格式的
     * @return
     */
    @Override
    public List<LayUiTree> selectAllMenu() {
        //查询所有的菜单
        List<Menu> menus = menuMapper.selectAllMenu();
        //并组装成tree格式的
        return TreeUtils.getChildPerms(menus, 0);
    }
    @Override
    public List<LayUiTable> selectMenu(){return menuMapper.selectMenu();}

    @Override
    public List<LayUiTree> selectAllMenuByName(String loginName) {
        //查询所有的菜单
        List<Menu> menus = menuMapper.selectAllMenuByName(loginName);
        //并组装成tree格式的
        return TreeUtils.getChildPerms(menus, 0);
    }
    //菜单管理
    @Override
    public PageInfo<Menu> selectAllMenu(int page, int limit) {
        //开始分页,第一个参数是当前第几页，第二个参数是一页显示多少行
        PageHelper.startPage(page, limit);
        List<Menu> mymenus = menuMapper.selectAllMenu();
        //结束分页,pageInfo封装了分页之后所有数据
        PageInfo<Menu> pageInfo= new PageInfo(mymenus);
        return pageInfo;
    }
    @Override
    public int insertSelective(Menu record) {

        return menuMapper.insertSelective(record);
    }
    @Override
    public int delMenuByID(List<String> ids) {

        return menuMapper.delMenuByID( ids) ;
    }

    @Override
    public int updateByPrimaryKeySelective(Menu record) {

        return menuMapper.updateByPrimaryKeySelective(record);
    }
    @Override
     public List<Menu> searchMenuById(int menuId){return menuMapper.searchMenuById(menuId);}

}
